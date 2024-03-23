package com.phoenix.sca.remote.adapter.wx;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/3/16 21:58
 */

import java.io.Serializable;

/**
 * 构建回复消息
 *
 * @author Administrator
 *
 */
public class ReplyMessageUtil implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[news]]></MsgType>
     * <ArticleCount>2</ArticleCount> <Articles> <item>
     * <Title><![CDATA[title1]]></Title>
     * <Description><![CDATA[description1]]></Description>
     * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
     * <item> <Title><![CDATA[title]]></Title>
     * <Description><![CDATA[description]]></Description>
     * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
     * </Articles> </xml>
     *
     * @Title sendImageTextMessage
     * @Description 回复图文消息
     * @param message
     * @return
     */
    public static String sendImageTextMessage(NewsOutputMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MessageType.IMAGE_TEXT_MESSAGE + "]]></MsgType>");
        sb.append("<ArticleCount>" + message.getArticleCount() + "</ArticleCount>");
        sb.append("<Articles> ");
        for (Articles article : message.getArticles()) {
            sb.append("<item>");
            if(article.getTitle()!=null && article.getTitle()!=""){
                sb.append("<Title><![CDATA[").append(article.getTitle()).append("]]></Title>");
            }
            if(article.getDescription()!=null && article.getDescription()!=""){
                sb.append("<Description><![CDATA[").append(article.getDescription()).append("]]></Description>");
            }
            if(article.getPicurl()!=null && article.getPicurl()!=""){
                sb.append("<PicUrl><![CDATA[").append(article.getPicurl()).append("]]></PicUrl>");
            }
            if(article.getUrl()!=null && article.getUrl()!=""){
                sb.append("<Url><![CDATA[").append(article.getUrl()).append("]]></Url>");
            }
            sb.append("</item>");
        }
        sb.append("</Articles>");
        sb.append("</xml>");
        return sb.toString();
    }

}
