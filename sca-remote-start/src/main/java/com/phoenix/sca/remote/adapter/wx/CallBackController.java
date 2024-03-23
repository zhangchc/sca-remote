package com.phoenix.sca.remote.adapter.wx;



import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 微信回调服务入口
 *
 * @author huajianbing
 */
@Slf4j
@RestController
public class CallBackController {
    @Autowired
    private WeChatService weChatService;

    @GetMapping("/callback")
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        checkWechatRequest(request, response);
    }

    /**
     * 接收微信消息处理并做分发
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @PostMapping("/callback")
    public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("==========================>>>>>>>>微信公众号");
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        if (!WebChatUtil.checkSignature(signature, timestamp, nonce)) {
            //消息不可靠，直接返回
            response.getWriter().write("");
            return;
        }
        //用户每次向公众号发送消息、或者产生自定义菜单点击事件时，响应URL将得到推送
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            //调用parseXml方法解析请求消息
            Map<String, String> map = RequestParse.parseXml(request);
            String msgType = map.get("MsgType");
            //处理输入消息，返回结果的xml
            String xml = null;
            if (MessageType.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
                xml = weChatService.parseEvent(map);
            } else {
                xml = weChatService.parseMessage(map);
            }
            //返回封装的xml
            response.getWriter().write(xml);
        } catch (Exception ex) {
            response.getWriter().write("");
        }
    }

    private void checkWechatRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //消息来源可靠性验证// 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        //成为开发者验证
        String echostr = request.getParameter("echostr");
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        PrintWriter out = response.getWriter();
        if (WebChatUtil.checkSignature(signature, timestamp, nonce)) {
            log.info("=======mywebchat请求校验成功 echostr is {}======", echostr);
            out.print(echostr);
        }
        out.close();
        out = null;
    }
}
