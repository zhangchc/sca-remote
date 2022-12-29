package com.zhang.sca.mapper;

import com.zhang.sca.model.po.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    List<User> selectUserInfoBycon(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}