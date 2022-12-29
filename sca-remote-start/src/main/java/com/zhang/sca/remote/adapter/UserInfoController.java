package com.zhang.sca.remote.adapter;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zhang.sca.common.enums.BizErrorCode;
import com.zhang.sca.common.response.LegoPageResponseInfo;
import com.zhang.sca.facade.api.UserInfoService;
import com.zhang.sca.facade.model.dto.UserInfoRequest;
import com.zhang.sca.facade.model.dto.UserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserInfoController {
    @Autowired
    private UserInfoService userService;

//    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
//    public LegoPageResponseInfo getUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
//        if (Objects.isNull(userInfoRequest.getUserId())) {
//            log.error("参数为null");
//            return LegoPageResponseInfo.paramError(BizErrorCode.ARUGMENT_ERROR.getMessage());
//        }
//        log.info("======userId={}", JSONObject.toJSONString(userInfoRequest.getUserId()));
//        LegoPageResponseInfo responseInfo = null;
//        ResponseInfo<UserInfoDTO> dto = userService.test(userInfoRequest.getUserId());
//        log.info("dto={}", JSONObject.toJSONString(dto));
//        return null;
//    }

    /**
     * 获取用户列表查询
     * @param userInfoRequest
     * @return
     */
    @RequestMapping(value = "/getUserInfoList", method = RequestMethod.POST)
    public LegoPageResponseInfo getUserInfoList(@RequestBody UserInfoRequest userInfoRequest) {
        LegoPageResponseInfo result;
        try {
            log.info("获取用户列表 入参：", JSONObject.toJSONString(userInfoRequest));
            if (Objects.isNull(userInfoRequest)) {
                log.error("入参对象为null");
                return LegoPageResponseInfo.paramError(BizErrorCode.ARUGMENT_ERROR.getMessage());
            }
            PageInfo<UserInfoResponse> pageInfo = userService.selectUserInfoBycon(userInfoRequest);
            Long total = pageInfo.getTotal();
            result = LegoPageResponseInfo.success(pageInfo.getList(), total.intValue());
        } catch (Exception e) {
            log.error("用户列表查询异常:",e);
            return LegoPageResponseInfo.systemError("用户列表查询异常");
        }
         return result;
    }
}
