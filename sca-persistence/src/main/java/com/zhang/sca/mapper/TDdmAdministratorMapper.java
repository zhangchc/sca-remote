package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmAdministrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmAdministratorMapper extends ExpandBaseMapper<TDdmAdministrator> {

    int insertSelective(TDdmAdministrator record);

    TDdmAdministrator selectByPrimaryKey(Long id);

    List<TDdmAdministrator> searchByEnterpriseId(@Param("enterpriseId") Long enterpriseId);

    TDdmAdministrator getByEnterpriseIdAndUserId(@Param("enterpriseId") Long enterpriseId, @Param("userId")  Long userId);

    int updateByPrimaryKeySelective(TDdmAdministrator record);

    int updateByPrimaryKey(TDdmAdministrator record);

    int batchInsert(@Param("list") List<TDdmAdministrator> list);

    TDdmAdministrator getEnterpriseOwner(Long enterpriseId);

    int removeEnterpriseAdministrators(Long enterpriseId);
}
