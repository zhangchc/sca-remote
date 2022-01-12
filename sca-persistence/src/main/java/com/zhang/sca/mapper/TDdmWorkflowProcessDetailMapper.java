package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmWorkflowProcessDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmWorkflowProcessDetailMapper {

    int insert(TDdmWorkflowProcessDetail record);

    int insertSelective(TDdmWorkflowProcessDetail record);

    TDdmWorkflowProcessDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmWorkflowProcessDetail record);

    int updateByPrimaryKey(TDdmWorkflowProcessDetail record);

    int batchInsert(@Param("list") List<TDdmWorkflowProcessDetail> list);

    List<TDdmWorkflowProcessDetail> selectPrepareAuditByProcessIdAndEnterpriseId(@Param("processId") Long processId, @Param("enterpriseId") Long enterpriseId);

    int updateIgnore(@Param("processId") Long processId, @Param("processUserId") Long processUserId);

    Long selectIdByProcessIdAndUser(TDdmWorkflowProcessDetail detail);
}
