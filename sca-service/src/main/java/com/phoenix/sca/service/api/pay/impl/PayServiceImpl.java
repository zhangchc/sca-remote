package com.phoenix.sca.service.api.pay.impl;

import com.alibaba.fastjson.JSON;
import com.phoenix.sca.facade.api.pay.PayService;
import com.phoenix.sca.facade.api.pay.dto.PayResponse;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import com.wechat.pay.java.core.RSAConfig;
import com.wechat.pay.java.service.payments.jsapi.JsapiServiceExtension;
import com.wechat.pay.java.service.payments.jsapi.model.Amount;
import com.wechat.pay.java.service.payments.jsapi.model.Payer;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayWithRequestPaymentResponse;
import com.wechat.pay.java.service.refund.RefundService;
import com.wechat.pay.java.service.refund.model.AmountReq;
import com.wechat.pay.java.service.refund.model.CreateRequest;
import com.wechat.pay.java.service.refund.model.Refund;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2023/3/13 17:46
 */
@Slf4j
@Service
public class PayServiceImpl implements PayService {
    /**
     * 商户号
     */
    public static String merchantId = "1638892549";
    /**
     * appid
     */
    public static String appId = "wxe5ac0ecf0d57034b";
    /**
     * 商户API私钥路径
     */
    public static String privateKeyPath = "/Users/zhangchuancun/workspace/SCA/sca-remote-start/src/main/resources/apiclient_key.pem";


    public static String wechatPayCertificatePath = "/Users/zhangchuancun/workspace/SCA/sca-remote-start/src/main/resources/apiclient_cert.pem";

    /**
     * 商户证书序列号
     */
    public static String merchantSerialNumber = "5B472D9FC418FB7FE086D20910FF7EE88DEFCF65";
    /**
     * 商户APIV3密钥
     */
    public static String apiV3key = "LCWa7lyWC2KLWXL1aQOxQTUjVvmKfZPA";

    @Override
    public PayResponse rePay() {
        Config config =
                new RSAAutoCertificateConfig.Builder()
                        .merchantId(merchantId)
                        .privateKeyFromPath(privateKeyPath)
                        .merchantSerialNumber(merchantSerialNumber)
                        .apiV3Key(apiV3key)
                        .build();

        JsapiServiceExtension service =
                new JsapiServiceExtension.Builder()
                        .config(config)
                        .signType("RSA") // 不填则默认为RSA
                        .build();

        PrepayRequest request = new PrepayRequest();
        Amount amount = new Amount();
        amount.setTotal(1);
        request.setAmount(amount);
        request.setAppid(appId);
        request.setMchid(merchantId);
        request.setDescription("测试商品标题");
        request.setNotifyUrl("https://cavini-gateway.yhcases.com/cavini/base/api/pay_notify");
        request.setOutTradeNo("out_trade_no_006");
        Payer pay = new Payer();
        pay.setOpenid("oXo-X5Ts3h6Z7u7ucqAVgXkCmxBc");
        request.setPayer(pay);
        // 调用接口
        PrepayWithRequestPaymentResponse response = service.prepayWithRequestPayment(request);
        log.info("预支付信息:{}", JSON.toJSONString(response));
        Map map =(Map)JSON.toJSON(response);
        PayResponse dto=new PayResponse();
        dto.setAppId(String.valueOf(map.get("appId")));
        dto.setNonceStr(String.valueOf(map.get("nonceStr")));
        dto.setPaySign(String.valueOf(map.get("paySign")));
        dto.setPackageStr(String.valueOf(map.get("packageVal")));
        dto.setSignType(String.valueOf(map.get("signType")));
        dto.setTimeStamp(String.valueOf(map.get("timeStamp")));
        return dto;
    }

//回调样例
//    {
//        "id": "ef89aa64-1d3e-5b43-b88f-b04cfcd4669e",
//            "create_time": "2023-03-14T16:51:15+08:00",
//            "resource_type": "encrypt-resource",
//            "event_type": "TRANSACTION.SUCCESS",
//            "summary": "支付成功",
//            "resource": {
//        "original_type": "transaction",
//                "algorithm": "AEAD_AES_256_GCM",
//                "ciphertext": "dQ2vjkOQabUzti2jhmnvCbMNAJACT78NJwQfKqQ7cozQjCVLE+eRqPQuNxCtiLpQryfqRn8otlSZrWDQOOlEwcMgTcElmOUoU7IvTq3DeT8TU5bR9HrKEfibUg9IuxHA/+QPYTmsR9lWbTfG+MPEC4ShosIrLiH/uiNkPMVqQZrrstwvugXUd3MffqmXgWpDSkaeUcHKAUR+cnBeX60VIIlJll299ZEMrEamNl/sVa8TIJ/h4G3pwA8KhKdQnfdMHX7lDH54T4RHae7suMiDE3fbpV0zj6PO9EJ560w+ZUREsrbQHo3GwYfh6OdCsIHhUE7nMeEg8wFEpmM2SXDozDh+gwWdRX4YV1Gho+EmYVBOcZBUdAPDqdzJESLJWZHAmtvL93Z4RI0Mso8CdUCBisszbLIc00ViV1YbB2WR/+XNRQcz9OK6oWruYvvj8H0G+XOYR4UufJsv9BjX+pm16YpvehaZK0lhCFLcJ5h+oMGCrPyAXJvXGn5rs8KufwJJM3rjfuAkvtXUk6p80dY3e2bVP1P6HOosLGa4tPHuWDE3wT7ILdM7ZmBZ3P8dl8/utvPd",
//                "associated_data": "transaction",
//                "nonce": "5FofpmNKa8aP"
//    }
//    }



    public String refound() {
        // 初始化商户配置
        RSAConfig config =
                new RSAConfig.Builder()
                        .merchantId(merchantId)
                        // 使用 com.wechat.pay.java.core.util 中的函数从本地文件中加载商户私钥，商户私钥会用来生成请求的签名
                        .privateKeyFromPath(privateKeyPath)
                        .merchantSerialNumber(merchantSerialNumber)
                        .wechatPayCertificatesFromPath(wechatPayCertificatePath)
                        .build();

        // 初始化服务
        RefundService service = new RefundService.Builder().config(config).build();
        // ... 调用接口
//        try {
        CreateRequest request = new CreateRequest();
        request.setOutRefundNo("111");
        request.setTransactionId("111");
        AmountReq amount = new AmountReq();
        amount.setRefund(100l);
        amount.setTotal(200l);
        amount.setCurrency("CNY");
        request.setAmount(amount);
        // 调用request.setXxx(val)设置所需参数，具体参数可见Request定义
        // 调用接口
        Refund response = service.create(request);
//        } catch (HttpException e) { // 发送HTTP请求失败
//            // 调用e.getHttpRequest()获取请求打印日志或上报监控，更多方法见HttpException定义
//        } catch (ServiceException e) { // 服务返回状态小于200或大于等于300，例如500
//            // 调用e.getResponseBody()获取返回体打印日志或上报监控，更多方法见ServiceException定义
//        } catch (MalformedMessageException e) { // 服务返回成功，返回体类型不合法，或者解析返回体失败
//            // 调用e.getMessage()获取信息打印日志或上报监控，更多方法见MalformedMessageException定义
//        }
        return null;
    }

//    public static void main(String[] args) {
//        PayServiceImpl s = new PayServiceImpl();
//        s.refound();
//    }
}
