package com.zhang.sca.facade.api;

import com.zhang.sca.facade.ResponseInfo;
import com.zhang.sca.facade.model.dto.UserDTO;

public interface UserService {
   ResponseInfo<UserDTO> test(Long id);
}
