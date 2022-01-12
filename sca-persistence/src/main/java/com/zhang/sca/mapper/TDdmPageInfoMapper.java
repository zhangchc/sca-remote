package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmPageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmPageInfoMapper extends ExpandBaseMapper<TDdmPageInfo>{

    int insertSelective(TDdmPageInfo record);

    TDdmPageInfo selectByPrimaryKey(@Param("enterpriseId") Long enterpriseId, @Param("pageId") Long pageId);

    List<TDdmPageInfo> searchByEnterpriseIdAndAppId(@Param("enterpriseId") Long enterpriseId, @Param("appId") Long appId);

    int updateByPrimaryKeySelective(TDdmPageInfo record);

}
