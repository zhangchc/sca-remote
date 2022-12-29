package com.zhang.sca.remote.adapter;

import com.alibaba.fastjson.JSONObject;
import com.zhang.sca.common.enums.BizErrorCode;
import com.zhang.sca.common.response.LegoPageResponseInfo;
import com.zhang.sca.facade.ResponseInfo;
import com.zhang.sca.facade.api.UserService;
import com.zhang.sca.facade.model.dto.UserInfoDTO;
import com.zhang.sca.facade.model.dto.UserInfoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class CustomerController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUserInfo",method= RequestMethod.POST)
    public LegoPageResponseInfo getUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        if(Objects.isNull(userInfoRequest.getUserId())){
            log.error("参数为null");
            return LegoPageResponseInfo.paramError(BizErrorCode.ARUGMENT_ERROR.getMessage());
        }
        log.info("======userId={}" , JSONObject.toJSONString(userInfoRequest.getUserId()));
        LegoPageResponseInfo responseInfo = null;
        ResponseInfo<UserInfoDTO> dto = userService.test(userInfoRequest.getUserId());
        log.info("dto={}", JSONObject.toJSONString(dto));
        return null;
    }
}
