package com.phoenix.sca.facade.api;

import com.github.pagehelper.PageInfo;
import com.phoenix.sca.facade.model.dto.UserInfoRequest;
import com.phoenix.sca.facade.model.dto.UserInfoResponse;

public interface UserInfoService {

    PageInfo<UserInfoResponse> selectUserInfoBycon(UserInfoRequest user);

    UserInfoResponse selectUserInfoByUserId(UserInfoRequest userRequest);

}