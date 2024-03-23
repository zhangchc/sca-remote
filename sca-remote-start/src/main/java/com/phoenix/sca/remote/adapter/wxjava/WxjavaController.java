package com.phoenix.sca.remote.adapter.wxjava;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.service.WxOAuth2Service;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/3/18 14:18
 */
@RestController
@RequestMapping("/wxjava/mp")
@Slf4j
public class WxjavaController {
    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpConfigStorage wxMpConfigStorage;
    @Autowired
    private WxMpMessageRouter wxMpMessageRouter;

//    @GetMapping("test")
//    public void testAutowire(){
//        System.out.println(wxMpService);
//        System.out.println(wxMpConfigStorage);
//    }
    @GetMapping("message")
    public String configAccess(String signature,String timestamp,String nonce,String echostr) {
        // 校验签名
        if (wxMpService.checkSignature(timestamp, nonce, signature)){
            // 校验成功原样返回echostr
            return echostr;
        }
        // 校验失败
        return null;
    }

    /**
     * 微信公众号根据路由返回消息内容
     * @param requestBody
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    @PostMapping(value = "message", produces = "application/xml; charset=UTF-8")
    public String handleMessage(@RequestBody String requestBody,
                                @RequestParam("signature") String signature,
                                @RequestParam("timestamp") String timestamp,
                                @RequestParam("nonce") String nonce) {
        log.info("handleMessage调用");

        // 校验消息是否来自微信
        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
        }
        // 解析消息体，封装为对象
        WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
        WxMpXmlOutMessage outMessage;
        try {
            // 将消息路由给对应的处理器，获取响应
            outMessage = wxMpMessageRouter.route(inMessage);
        } catch (Exception e) {
            log.error("微信消息路由异常", e);
            outMessage = null;
        }
        // 将响应消息转换为xml格式返回
        return outMessage == null ? "" : outMessage.toXml();
    }

    /**
     * 微信公众号创建菜单
     * @return
     * @throws WxErrorException
     */
    @GetMapping("createMenu")
    public String createMenu() throws WxErrorException {
        // 创建菜单对象
        WxMenu menu = new WxMenu();
        // 创建按钮1
        WxMenuButton button1 = new WxMenuButton();
        button1.setType(WxConsts.MenuButtonType.CLICK);
        button1.setName("今日歌曲");
        button1.setKey("V1001_TODAY_MUSIC");
        // 创建按钮2
        WxMenuButton button2 = new WxMenuButton();
        button2.setName("菜单");
        // 创建按钮2的子按钮1
        WxMenuButton button21 = new WxMenuButton();
        button21.setType(WxConsts.MenuButtonType.VIEW);
        button21.setName("搜索");
        button21.setUrl("https://www.baidu.com/");
        // 创建按钮2的子按钮2
        WxMenuButton button22 = new WxMenuButton();
        button22.setType(WxConsts.MenuButtonType.VIEW);
        button22.setName("视频");
        button22.setUrl("https://3c3d23d1.r10.cpolar.top/wxjava/mp/buildAuthPage");
        // 创建按钮2的子按钮3
        WxMenuButton button23 = new WxMenuButton();
        button23.setType(WxConsts.MenuButtonType.CLICK);
        button23.setName("赞一下我们");
        button23.setKey("V1001_GOOD");
        // 将子按钮添加到按钮2
        button2.getSubButtons().add(button21);
        button2.getSubButtons().add(button22);
        button2.getSubButtons().add(button23);

        WxMenuButton button3 = new WxMenuButton();
        button3.setType(WxConsts.MenuButtonType.CLICK);
        button3.setName("刚正不阿");
        button3.setKey("111");


        // 将按钮1和你按钮2添加到菜单
        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);

        log.info(JSON.toJSONString(menu));
        // 创建按钮
        return wxMpService.getMenuService().menuCreate(menu);
    }


    /**
     * 微信发送模版消息
     * @return
     * @throws WxErrorException
     */
    @GetMapping("sendTemplateMessage")
    public String sendTemplateMessage() throws WxErrorException {
        System.out.println(wxMpConfigStorage);
        // 创建模板消息，设置模板id、指定模板消息要发送的目标用户
        WxMpTemplateMessage wxMpTemplateMessage = WxMpTemplateMessage.builder()
                .templateId("pXkKXU8eDtLbfadA8riSHY6XqrguNgz683z4Q8LZ6T0")
                .toUser("oiIuV6qjRMp2rRE2qxC-tl6Mwef0")
                .build();
        // 填充模板消息中的变量
        wxMpTemplateMessage.addData(new WxMpTemplateData("goodsName", "华为mate40pro"));
        wxMpTemplateMessage.addData(new WxMpTemplateData("time", "2020-10-25"));
        wxMpTemplateMessage.addData(new WxMpTemplateData("price", "6999"));
        wxMpTemplateMessage.addData(new WxMpTemplateData("remark", "麒麟9000牛逼"));
        // 发送模板消息，返回消息id
        return wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
    }
    @GetMapping("test")
    public void test() throws WxErrorException {
        log.info(JSON.toJSONString( wxMpService.getAccessToken()));
    }

    @GetMapping("buildAuthPage")
    public String auth() {
        WxOAuth2Service oAuth2Service = wxMpService.getOAuth2Service();
        // 构建授权url
        return oAuth2Service.buildAuthorizationUrl("http://3c3d23d1.r10.cpolar.top/wxjava/mp/callback",
                WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
    }

    @GetMapping("callback")
    public WxOAuth2UserInfo callback(String code) throws WxErrorException {
        WxOAuth2Service oAuth2Service = wxMpService.getOAuth2Service();
        // 利用code获取accessToken
        WxOAuth2AccessToken accessToken = oAuth2Service.getAccessToken(code);
        // 利用accessToken获取用户信息
        WxOAuth2UserInfo userInfo = oAuth2Service.getUserInfo(accessToken, null);
        return userInfo;
    }

    @GetMapping("qrcode")
    public void qrcode(String code) throws WxErrorException {
        WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateLastTicket(123);
        File file = wxMpService.getQrcodeService().qrCodePicture(ticket);
        System.out.println(file.getAbsolutePath());
    }





}
