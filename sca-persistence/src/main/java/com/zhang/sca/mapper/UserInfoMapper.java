package com.zhang.sca.mapper;

import com.zhang.sca.model.po.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userId);

    List<UserInfo> selectUserInfoBycon(UserInfo record);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}