package com.phoenix.sca.remote.adapter.pay;

import com.alibaba.fastjson.JSONObject;
import com.phoenix.sca.common.response.ResponseInfo;
import com.phoenix.sca.facade.api.pay.PayService;
import com.phoenix.sca.facade.api.pay.dto.PayResponse;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2023/3/13 17:41
 */

@Slf4j
@RestController
@RequestMapping("/pay")
@RefreshScope
public class PayController {
    @Autowired
    private PayService payService;
    @RequestMapping(value = "/repay", method = RequestMethod.POST)
    public ResponseInfo<PayResponse> repay(@RequestBody UserInfoRequest userInfoRequest) {
        PayResponse result = payService.rePay();
        log.info("pay={}", JSONObject.toJSONString(result));
        return ResponseInfo.success(result);

    }
}
