package com.zhang.sca.facade.api;

import com.github.pagehelper.PageInfo;
import com.zhang.sca.facade.ResponseInfo;
import com.zhang.sca.facade.model.dto.UserInfoDTO;
import com.zhang.sca.facade.model.dto.UserInfoRequest;
import com.zhang.sca.facade.model.dto.UserInfoResponse;

public interface UserService {
   ResponseInfo<UserInfoDTO> test(Long id);

   PageInfo<UserInfoResponse> selectUserInfoBycon(UserInfoRequest user);
}
