package com.phoenix.sca.remote.adapter.wx;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/3/16 21:47
 */
public class TextMessage extends BaseMessage {
    //文本消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String getMsgType() {
        return MessageType.TEXT_MESSAGE.toString();
    }

}
