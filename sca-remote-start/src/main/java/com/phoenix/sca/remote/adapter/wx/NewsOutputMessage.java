package com.phoenix.sca.remote.adapter.wx;


import java.util.List;

/**
 * 提供了获取多条图文消息信息
 *
 * @author Administrator
 *
 */
public class NewsOutputMessage extends BaseOutMessage {
    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<Articles> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Articles> getArticles() {
        return Articles;
    }

    public void setArticles(List<Articles> articles) {
        Articles = articles;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_NEWS.toString();
    }
}
