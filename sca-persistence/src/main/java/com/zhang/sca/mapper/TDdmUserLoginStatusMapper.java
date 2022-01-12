package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmUserLoginStatus;

public interface TDdmUserLoginStatusMapper extends ExpandBaseMapper<TDdmUserLoginStatus> {

    int insertSelective(TDdmUserLoginStatus record);

    TDdmUserLoginStatus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmUserLoginStatus record);

    int updateByPrimaryKey(TDdmUserLoginStatus record);

}