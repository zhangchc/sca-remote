package com.zhang.sca.service.api.impl;

import com.zhang.sca.facade.ResponseInfo;
import com.zhang.sca.facade.api.UserService;
import com.zhang.sca.facade.model.dto.UserDTO;
import com.zhang.sca.mapper.UserMapper;
import com.zhang.sca.model.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public ResponseInfo<UserDTO> test(Long id) {
        User user =userMapper.selectByPrimaryKey(id);

        UserDTO dto =new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        ResponseInfo<UserDTO> userDto =new ResponseInfo<UserDTO>();
        userDto.setData(dto);
        return userDto;
    }
}
