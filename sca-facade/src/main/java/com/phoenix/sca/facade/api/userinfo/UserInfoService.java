package com.phoenix.sca.facade.api.userinfo;

import com.github.pagehelper.PageInfo;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoRequest;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoResponse;

public interface UserInfoService {

    PageInfo<UserInfoResponse> selectUserInfoBycon(UserInfoRequest user);

    UserInfoResponse selectUserInfoByUserId(UserInfoRequest userRequest);

    Boolean saveUserInfo(UserInfoRequest userRequest);


}
