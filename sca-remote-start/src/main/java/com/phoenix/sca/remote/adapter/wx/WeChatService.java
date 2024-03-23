package com.phoenix.sca.remote.adapter.wx;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/3/16 21:44
 */
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huajianbing
 */
@Slf4j
@Service
public class WeChatService {
    private static final String NI_HAO = "你好";
    private static final String ZAI_MA = "在吗";


    /**
     * 处理微信发来的请求 map 消息业务处理分发
     *
     * @param map map
     * @return 返回消息
     */
    public String parseMessage(Map<String, String> map) {
        String respXml = null;
        try {
            // 发送方帐号
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            // 取得消息类型
            String MsgType = map.get("MsgType");
            // 发现直接把要返回的信息直接封装成replyMap集合，然后转换成 xml文件，是不是实体类可以不用了
            Map<String, String> replyMap = new HashMap<String, String>();
            replyMap.put("ToUserName", fromUserName);
            replyMap.put("FromUserName", toUserName);
            replyMap.put("CreateTime", String.valueOf(System.currentTimeMillis()));
            if (MsgType.equals(MessageType.TEXT_MESSAGE)) {
                // 用map集合封装
                String keyword = map.get("Content");
                if (NI_HAO.equals(keyword) || ZAI_MA.equals(keyword)) {
                    String content = sendTextMsg(map.get("Content"));
                    // 封装文本返回消息
                    TextMessage textMessage = new TextMessage();
                    textMessage.setToUserName(fromUserName);
                    textMessage.setFromUserName(toUserName);
                    textMessage.setCreateTime(System.currentTimeMillis());
                    replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
                    replyMap.put("Content", content);
                    respXml = XmlUtil.xmlFormat(replyMap, true);
                } else {
                    //推送商品模板消息
//                    NewsOutputMessage message = searchProductMsg(keyword);
                    NewsOutputMessage message =null;
                    if (message != null) {
                        message.setToUserName(fromUserName);
                        message.setFromUserName(toUserName);
                        message.setCreateTime(System.currentTimeMillis());
                        respXml = ReplyMessageUtil.sendImageTextMessage(message);
                    } else {
                        respXml = "success";
                    }
                }
            }
        } catch (Exception e) {
            log.error("parseMessage is exception");
        }
        return respXml;
    }

    /**
     * // 事件消息业务分发
     *
     * @param map map
     * @return 返回xml 数据
     */
    public String parseEvent(Map<String, String> map) {
        String respXml = null;
        try {
            // 发送方帐号
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            //获取事件类型
            String eventType = map.get("Event");
            // 发现直接把要返回的信息直接封装成replyMap集合，然后转换成 xml文件，是不是实体类可以不用了
            Map<String, String> replyMap = new HashMap<String, String>();
            replyMap.put("ToUserName", fromUserName);
            replyMap.put("FromUserName", toUserName);
            replyMap.put("CreateTime", String.valueOf(System.currentTimeMillis()));
            if (eventType.equals(MessageType.EVENT_TYPE_SUBSCRIBE)) {
                // 关注
                replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", WechatConstant.subscribeMsg);
                respXml = XmlUtil.xmlFormat(replyMap, true);
            }
        } catch (Exception e) {
            log.error("parseEvent is exception");
        }
        return respXml;
    }


    /**
     * 发送普通文本消息
     *
     * @param message 发送消息
     * @return 返回消息
     */
    private String sendTextMsg(String message) {
        if (ZAI_MA.equals(message)) {
            return WechatConstant.sendZaiMaMessageReturn;
        } else {
            return WechatConstant.sendNiHaoMessageReturn;
        }
    }

//    /**
//     * 查找商品
//     *
//     * @param keyword 关键词
//     * @return 返回图文消息
//     */
//    private NewsOutputMessage searchProductMsg(String keyword) {
//        NewsOutputMessage message = new NewsOutputMessage();
//        String result = searchProductWechatAdapter.searchProductByKeyWord(keyword);
//        if (StringUtils.isEmpty(result)) {
//            return null;
//        }
//        JSONObject jsonObject = JSONObject.parseObject(result);
//        JSONObject data = jsonObject.getJSONObject("data");
//        if (data != null) {
//            JSONArray jsonArray = data.getJSONArray("hits");
//            Articles article = new Articles();
//            List<Articles> articles = new ArrayList<>();
//            String lastName;
//            StringBuilder finalName;
//            StringBuilder forardUrl;
//            for (int i = 0; i < jsonArray.size(); i++) {
//                finalName = new StringBuilder();
//                forardUrl = new StringBuilder();
//                JSONObject object = jsonArray.getJSONObject(i);
//                if (i == 0) {
//                    BigDecimal price = object.getBigDecimal("price");
//                    if (price != null) {
//                        price = price.setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
//                    } else {
//                        price = new BigDecimal(100);
//                    }
//                    finalName.append("您是不是想购买【").append(price).append("元】")
//                            .append(object.getString("name")).append(object.getString("gift"));
//                    forardUrl.append("http://m.111.com.cn/yyw/wap/item/index.html#/item/").append(object.getString("itemId")).append("?tracker_u=100399");
//                    if (finalName.length() > 38) {
//                        lastName = finalName.substring(0, 38) + "...";
//                    } else {
//                        lastName = finalName.toString();
//                    }
//                    article = new Articles();
//                    article.setTitle(lastName);
//                    article.setDescription(lastName);
//                    article.setPicurl(WechatConstant.picMessageFirstPic);
//                    article.setUrl(forardUrl.toString());
//                    articles.add(article);
//                } else {
//                    finalName.append("【").append(object.getBigDecimal("price").setScale(2, BigDecimal.ROUND_HALF_UP))
//                            .append(object.getString("name")).append(object.getString("gift"));
//                    forardUrl.append("http://m.111.com.cn/yyw/wap/item/index.html#/item/").append(object.getString("itemId")).append("?tracker_u=100399");
//                    if (finalName.length() > 38) {
//                        lastName = finalName.substring(38) + "...";
//                    } else {
//                        lastName = finalName.toString();
//                    }
//                    article = new Articles();
//                    article.setTitle(lastName);
//                    article.setDescription(lastName);
//                    article.setPicurl(object.getString("img"));
//                    article.setUrl(forardUrl.toString());
//                    articles.add(article);
//                }
//            }
//            if (CollectionUtil.isNotEmpty(articles)) {
//                message.setArticleCount(articles.size());
//                message.setArticles(articles);
//                return message;
//            }
//        }
//        return null;
//    }
}
