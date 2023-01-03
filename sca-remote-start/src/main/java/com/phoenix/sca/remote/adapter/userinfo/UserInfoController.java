package com.phoenix.sca.remote.adapter.userinfo;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.phoenix.sca.common.exception.BizErrorCode;
import com.phoenix.sca.common.response.PageResponseInfo;
import com.phoenix.sca.common.response.ResponseInfo;
import com.phoenix.sca.facade.api.userinfo.UserInfoService;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoRequest;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoResponse;
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
    private UserInfoService userInfoService;

    /**
     * 根据id获取用户信息
     * @param userInfoRequest
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public ResponseInfo<UserInfoResponse> getUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        if (Objects.isNull(userInfoRequest.getUserId())) {
            log.error("参数为null");
            return ResponseInfo.paramError(BizErrorCode.ARUGMENT_ERROR.getMessage());
        }
        log.info("======userId={}", JSONObject.toJSONString(userInfoRequest.getUserId()));
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
        try {
            log.info("获取用户列表 入参：", JSONObject.toJSONString(userInfoRequest));
            if (Objects.isNull(userInfoRequest)) {
                log.error("入参对象为null");
                return PageResponseInfo.paramError(BizErrorCode.ARUGMENT_ERROR.getMessage());
            }
            PageInfo<UserInfoResponse> pageInfo = userInfoService.selectUserInfoBycon(userInfoRequest);
            Long total = pageInfo.getTotal();
            result = PageResponseInfo.success(pageInfo.getList(), total.intValue());
        } catch (Exception e) {
            log.error("用户列表查询异常:", e);
            return PageResponseInfo.systemError("用户列表查询异常");
        }
        return result;
    }

    /**
     * 新增用户信息
     * @param userInfoRequest
     */
    @RequestMapping(value="/saveUserInfo",method=RequestMethod.POST)
    public  ResponseInfo saveUserInfo(@RequestBody UserInfoRequest userInfoRequest){
        userInfoService.saveUserInfo(userInfoRequest);
        return ResponseInfo.build(1,"新增用户信息成功！",null);
    }

    /**
     * 更新用户信息
     * @param userInfoRequest
     */
    @RequestMapping(value="/updateUserInfo",method=RequestMethod.POST)
    public void updateUserInfo(@RequestBody UserInfoRequest userInfoRequest){

    }
}
