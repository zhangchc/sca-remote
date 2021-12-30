package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmAppInfo;
import org.apache.ibatis.annotations.Param;

public interface TDdmAppInfoMapper  extends ExpandBaseMapper<TDdmAppInfo> {
//public interface TDdmAppInfoMapper  {

    int insertSelective(TDdmAppInfo record);

    TDdmAppInfo selectByEnterpriseIdAndAppId(@Param("enterpriseId") Long enterpriseId, @Param("appId")  Long appId);

    int updateByPrimaryKeyAndEnterpriseIdSelective(TDdmAppInfo tDdmAppInfo);

}
