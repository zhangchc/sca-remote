package com.phoenix.sca.remote.adapter.userinfo;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.phoenix.sca.common.config.CommonProperties;
import com.phoenix.sca.common.response.PageResponseInfo;
import com.phoenix.sca.common.response.ResponseCode;
import com.phoenix.sca.common.response.ResponseInfo;
import com.phoenix.sca.facade.api.userinfo.UserInfoService;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoRequest;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Resource
    private CommonProperties commonProperties;

    //    @Value(value="${common.jwt.tokenHeader}")
//    private String token;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseInfo<UserInfoResponse> login(@RequestBody UserInfoRequest userInfoRequest) {
        if (StringUtils.isBlank(userInfoRequest.getUsername()) || StringUtils.isBlank(userInfoRequest.getPassword())) {
            return ResponseInfo.paramError(ResponseCode.USER_LOGIN_CODE1.getCode(), ResponseCode.USER_LOGIN_CODE1.getMessage());
        }
        UserInfoResponse user = userInfoService.login(userInfoRequest);
        log.info("userinfo={}", JSONObject.toJSONString(user));
        if (ObjectUtils.isEmpty(user)) {
            return ResponseInfo.paramError(ResponseCode.USER_LOGIN_CODE2.getCode(), ResponseCode.USER_LOGIN_CODE2.getMessage());
        }
        return ResponseInfo.success(user);
    }

    /**
     * 根据id获取用户信息
     *
     * @param userInfoRequest
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public ResponseInfo<UserInfoResponse> getUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        if (Objects.isNull(userInfoRequest.getUserId())) {
            log.error("参数为null");
            return ResponseInfo.paramError(ResponseCode.PARAM_ERROR_CODE.getMessage());
        }
        log.info(commonProperties.getJwt().getTokenHeader() + "====");

        log.info("查询用户信息 userId={}", JSONObject.toJSONString(userInfoRequest.getUserId()));
        UserInfoResponse userInfo = userInfoService.selectUserInfoByUserId(userInfoRequest);
        return ResponseInfo.success(userInfo);
    }

    /**
     * 获取用户列表查询
     *
     * @param userInfoRequest
     * @return
     */
    @RequestMapping(value = "/getUserInfoList", method = RequestMethod.POST)
    public PageResponseInfo getUserInfoList(@RequestBody UserInfoRequest userInfoRequest) {
        PageResponseInfo result;

        log.info("获取用户列表 入参：{}", JSONObject.toJSONString(userInfoRequest));
        if (Objects.isNull(userInfoRequest)) {
            log.error("入参对象为null");
            return PageResponseInfo.paramError(ResponseCode.PARAM_ERROR_CODE.getMessage());
        }
        PageInfo<UserInfoResponse> pageInfo = userInfoService.selectUserInfoBycon(userInfoRequest);
        Long total = pageInfo.getTotal();
        result = PageResponseInfo.success(pageInfo.getList(), total.intValue());
        return result;
    }

    /**
     * 新增用户信息
     *
     * @param userInfoRequest
     */
    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
    public ResponseInfo saveUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        userInfoService.saveUserInfo(userInfoRequest);
        return ResponseInfo.build(ResponseCode.SUCCESS_CODE.getCode(), "新增用户信息成功！", null);
    }

    /**
     * 更新用户信息
     *
     * @param userInfoRequest
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public ResponseInfo updateUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        userInfoService.updateUserInfoByUserId(userInfoRequest);
        return ResponseInfo.build(ResponseCode.SUCCESS_CODE.getCode(), "更新用户信息成功！", null);
    }
}
