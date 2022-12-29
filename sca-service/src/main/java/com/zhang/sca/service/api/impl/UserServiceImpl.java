package com.zhang.sca.service.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.sca.facade.ResponseInfo;
import com.zhang.sca.facade.api.UserService;
import com.zhang.sca.facade.model.dto.UserInfoDTO;
import com.zhang.sca.facade.model.dto.UserInfoRequest;
import com.zhang.sca.facade.model.dto.UserInfoResponse;
import com.zhang.sca.mapper.UserMapper;
import com.zhang.sca.model.po.User;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private MapperFacade mapperFacade;
    @Override
    public ResponseInfo<UserInfoDTO> test(Long id) {
        User user =userMapper.selectByPrimaryKey(id);
        UserInfoDTO dto =new UserInfoDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        ResponseInfo<UserInfoDTO> userDto =new ResponseInfo<UserInfoDTO>();
        userDto.setData(dto);
        return userDto;
    }

    /**
     * 分页查询
     * @param userRequest
     * @return
     */
    @Override
   public PageInfo<UserInfoResponse> selectUserInfoBycon(UserInfoRequest userRequest){
        User user = mapperFacade.map(userRequest,User.class);
        PageInfo<UserInfoResponse> resultDto;
        PageHelper.startPage(Math.max(userRequest.getPageNo(),1),Math.min(userRequest.getPageSize(),100));
        List<User> userList = userMapper.selectUserInfoBycon(user);
        PageInfo<User> pageInfo=new PageInfo(userList);
        List<UserInfoResponse> userResponse=mapperFacade.mapAsList(userList,UserInfoResponse.class);
        resultDto=new PageInfo<>(userResponse);
        resultDto.setTotal(pageInfo.getTotal());
        System.out.println(JSONObject.toJSONString(resultDto));
        return resultDto;
   }
}
