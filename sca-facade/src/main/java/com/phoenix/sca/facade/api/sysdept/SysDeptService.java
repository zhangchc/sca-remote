package com.phoenix.sca.facade.api.sysdept;

import com.github.pagehelper.PageInfo;
import com.phoenix.sca.facade.api.sysdept.dto.SysDeptRequest;
import com.phoenix.sca.facade.api.sysdept.dto.SysDeptResponse;

public interface SysDeptService {
    Boolean saveDeptInfo(SysDeptRequest request);

    Boolean updateDeptInfo(SysDeptRequest request);

    PageInfo<SysDeptResponse> selectDdptBycon(SysDeptRequest request);

    SysDeptResponse selectUserInfoByUserId(SysDeptRequest request);
}
