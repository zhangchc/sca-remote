package com.phoenix.sca.service.api.userinfo.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phoenix.sca.common.exception.ServiceException;
import com.phoenix.sca.common.response.ResponseCode;
import com.phoenix.sca.entity.userinfo.UserInfo;
import com.phoenix.sca.facade.api.userinfo.UserInfoService;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoRequest;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoResponse;
import com.phoenix.sca.mapper.userinfo.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;
    @Autowired
    private MapperFacade mapperFacade;

    /**
     * 分页查询
     *
     * @param userRequest
     * @return
     */
    @Override
    public PageInfo<UserInfoResponse> selectUserInfoBycon(UserInfoRequest userRequest) {
        PageInfo<UserInfoResponse> resultDto;
        try {
            UserInfo user = mapperFacade.map(userRequest, UserInfo.class);
            PageHelper.startPage(Math.max(userRequest.getPageNo(), 1), Math.min(userRequest.getPageSize(), 100));
            List<UserInfo> userList = userInfoMapper.selectUserInfoBycon(user);
            PageInfo<UserInfo> pageInfo = new PageInfo(userList);
            List<UserInfoResponse> userResponse = mapperFacade.mapAsList(userList, UserInfoResponse.class);
            resultDto = new PageInfo<>(userResponse);
            resultDto.setTotal(pageInfo.getTotal());
        } catch (Exception e) {
            log.error("用户列表查询失败", e);
            throw new ServiceException(ResponseCode.SYS_ERROR_CODE.getCode(), "用户列表查询失败");
        }
        return resultDto;
    }

    /**
     * 获取用户基本信息
     *
     * @param userRequest
     * @return
     */
    public UserInfoResponse selectUserInfoByUserId(UserInfoRequest userRequest) {
        UserInfoResponse response = null;
        try {
            Long userId = userRequest.getUserId();
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
            response = mapperFacade.map(userInfo, UserInfoResponse.class);
        } catch (Exception e) {
            log.error("根据id获取用户信息失败", e);
            throw new ServiceException(ResponseCode.SYS_ERROR_CODE.getCode(), "根据id获取用户信息失败");
        }
        return response;
    }

    public Boolean saveUserInfo(UserInfoRequest userRequest) {
        log.info("保存用户信息-userRequest:{}", JSONObject.toJSONString(userRequest));
        int count = 0;
        try {
            UserInfo userInfo = mapperFacade.map(userRequest, UserInfo.class);
            count = userInfoMapper.insert(userInfo);
        } catch (Exception e) {
            log.error("保存用户信息失败", e);
            throw new ServiceException(ResponseCode.SYS_ERROR_CODE.getCode(), "保存用户信息失败");
        }
        return count > 0;
    }

    public Boolean updateUserInfoByUserId(UserInfoRequest userRequest) {
        log.info("保存用户信息-userRequest:{}", JSONObject.toJSONString(userRequest));
        int count = 0;
        try {
            UserInfo userInfo = mapperFacade.map(userRequest, UserInfo.class);
            userInfo.setUpdateTime(new Date());
            userInfo.setUpdateBy("admin");
            count = userInfoMapper.updateByPrimaryKey(userInfo);
        } catch (Exception e) {
            log.error("更新用户信息失败", e);
            throw new ServiceException(ResponseCode.SYS_ERROR_CODE.getCode(), "更新用户信息失败");
        }
        return count > 0;
    }
}
