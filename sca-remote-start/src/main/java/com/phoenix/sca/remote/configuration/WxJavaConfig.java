package com.phoenix.sca.remote.configuration;

import com.phoenix.sca.remote.handler.wx.ImageHandler;
import com.phoenix.sca.remote.handler.wx.SubscribeHandler;
import com.phoenix.sca.remote.handler.wx.TextHandler;
import com.phoenix.sca.remote.handler.wx.UnSubscribeHandler;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxJavaConfig {
    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private TextHandler textHandler;

    @Autowired
    private ImageHandler imageHandler;
    @Autowired
    private SubscribeHandler subscribeHandler;
    @Autowired
    private UnSubscribeHandler unSubscribeHandler;

    @Bean
    public WxMpMessageRouter messageRouter() {
        // 创建消息路由
        final WxMpMessageRouter router = new WxMpMessageRouter(wxMpService);
        // 添加文本消息路由
        router.rule().async(false).msgType(WxConsts.XmlMsgType.TEXT).handler(textHandler).end();
        // 添加图片消息路由
        router.rule().async(false).msgType(WxConsts.XmlMsgType.IMAGE).handler(imageHandler).end();
        //添加关注事件推送路由
        router.rule().async(false).msgType(WxConsts.XmlMsgType.EVENT).event(WxConsts.EventType.SUBSCRIBE).handler(subscribeHandler).end();
        //添加取消关注事件推送路由
        router.rule().async(false).msgType(WxConsts.XmlMsgType.EVENT).event(WxConsts.EventType.SUBSCRIBE).handler(unSubscribeHandler).end();
        return router;
    }
}

