package com.phoenix.sca.mapper.userinfo;

import com.phoenix.sca.entity.userinfo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userId);

    UserInfo selectByUserNameAndPass(UserInfo record);

    List<UserInfo> selectUserInfoBycon(UserInfo record);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}