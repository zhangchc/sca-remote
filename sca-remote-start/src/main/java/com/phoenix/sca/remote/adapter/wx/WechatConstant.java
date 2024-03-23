package com.phoenix.sca.remote.adapter.wx;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/3/16 21:53
 */
public interface WechatConstant {

    /**
     * 药网公众号APP ID
     */
    String APP_ID = "wx473619f9704d736b";

    /**
     * 药网公众号APP secret
     */
    String APP_SECRET ="6e2c7285ef01319a6f0a51d23a8a1201";

    /**
     * 关注返回文案
     */
    String subscribeMsg = "Hi，我是1姐，欢迎关注1药网！任何购药问诊和健康问题欢迎咨询，我们将竭诚为您的健康生活服务。温馨提示：1姐看到留言会马上回复哦！如果着急建议拨打客服热线400-007-0958咨询，谢谢！";
    /**
     * 发送“在吗”返回文案
     */
    String sendZaiMaMessageReturn = "您好，请问有什么可以帮助您？您是否有以下需求\n" +
            "您是否要找以下功能\n" +
            "\n" +
            "<a href=\"http://www.baidu.com\">跳转百度</a>\n" +
            "\n" +
            "<a href=\"http://sina.com\">找药</a>\n" +
            "\n" +
            "<a href=\"https://im.111.com.cn/yyw-im/pc/YYWIM.html?uid=&system=1_H5&department=100040\">咨询客服</a>";
    /**
     * 发送“你好” 返回文案
     */
    String sendNiHaoMessageReturn = "您好，请问有什么可以帮助您？您是否有以下需求\n" +
            "您是否要找以下功能\n" +
            "\n" +
            "<a href=\"http://m.111.com.cn/yyw/wap/order/#/orderList\">查看订单进度</a>\n" +
            "\n" +
            "<a href=\"http://m.111.com.cn/yyw/wap/category/#/\">找药</a>\n" +
            "\n" +
            "<a href=\"https://im.111.com.cn/yyw-im/pc/YYWIM.html?uid=&system=1_H5&department=100040\">咨询客服</a>";

    String picMessageFirstPic = "https://p3.maiyaole.com/img/cmsPage/2018b038e59b0919163622/toutu.jpg";
}
