package com.zhang.sca.service.api.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.sca.common.exception.ErrorCode;
import com.zhang.sca.common.exception.ServiceException;
import com.zhang.sca.facade.api.UserInfoService;
import com.zhang.sca.facade.model.dto.UserInfoRequest;
import com.zhang.sca.facade.model.dto.UserInfoResponse;
import com.zhang.sca.mapper.UserInfoMapper;
import com.zhang.sca.model.po.UserInfo;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userMapper;
    @Autowired
    private MapperFacade mapperFacade;

    /**
     * 分页查询
     * @param userRequest
     * @return
     */
    @Override
   public PageInfo<UserInfoResponse> selectUserInfoBycon(UserInfoRequest userRequest){
        PageInfo<UserInfoResponse> resultDto;
        try {
            UserInfo user = mapperFacade.map(userRequest, UserInfo.class);
            PageHelper.startPage(Math.max(userRequest.getPageNo(),1),Math.min(userRequest.getPageSize(),100));
            List<UserInfo> userList = userMapper.selectUserInfoBycon(user);
            PageInfo<UserInfo> pageInfo=new PageInfo(userList);
            List<UserInfoResponse> userResponse=mapperFacade.mapAsList(userList,UserInfoResponse.class);
            resultDto=new PageInfo<>(userResponse);
            resultDto.setTotal(pageInfo.getTotal());

        } catch (Exception e) {
            log.error("用户信息查询失败",e);
            throw new ServiceException(ErrorCode.SYSTEM_ERROR_CODE.getCode(), "service层 用户信息列表查询异常");
        }
        return resultDto;
   }
}
