package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmWorkflowProcessRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmWorkflowProcessRecordMapper {

    int insert(TDdmWorkflowProcessRecord record);

    int insertSelective(TDdmWorkflowProcessRecord record);

    TDdmWorkflowProcessRecord selectByPrimaryKey(Long id);

    List<TDdmWorkflowProcessRecord> selectByFormIdAndDataIdAndEnterpriseId(@Param("enterpriseId") Long enterpriseId, @Param("formId") Long formId, @Param("dataId") Long dataId);

    List<TDdmWorkflowProcessRecord> selectByPageIdAndDataIdAndEnterpriseId(@Param("enterpriseId") Long enterpriseId, @Param("pageId") Long formId, @Param("dataId") Long dataId);

    int updateByPrimaryKeySelective(TDdmWorkflowProcessRecord record);

    int updateByPrimaryKey(TDdmWorkflowProcessRecord record);

    int batchInsert(@Param("list") List<TDdmWorkflowProcessRecord> list);

}
