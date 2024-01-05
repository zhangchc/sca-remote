package com.phoenix.sca.facade.api.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayResponse implements Serializable {

    private static final long serialVersionUID = 1535610167662190943L;
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 随机字符串
     */
    private String nonceStr;

    /**
     * 签名
     */
    private String paySign;
    /**
     * 订单详情扩展字符串
     * JSAPI下单接口返回的prepay_id参数值，提交格式如：prepay_id=***
     * 示例值：prepay_id=wx201410272009395522657a690389285100
     */
    private String packageStr;
    /**
     * 签名方式
     */
    private String signType;
    /**
     * 时间戳
     */
    private String timeStamp;

    private String needPay;

    private  Boolean result;
    private String refundDes;
}
