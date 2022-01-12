package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmWorkflowTemplateDetailApproveDraft;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmWorkflowTemplateDetailApproveDraftMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TDdmWorkflowTemplateDetailApproveDraft record);

    int insertSelective(TDdmWorkflowTemplateDetailApproveDraft record);

    TDdmWorkflowTemplateDetailApproveDraft selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmWorkflowTemplateDetailApproveDraft record);

    int updateByPrimaryKey(TDdmWorkflowTemplateDetailApproveDraft record);

    int batchInsert(@Param("list") List<TDdmWorkflowTemplateDetailApproveDraft> list);

    int deleteByNodeId(@Param("nodeId") Long nodeId, @Param("updateUser") Long updateUser);
    int logicDeleteByNodeIdAndEnterpriseId(@Param("nodeId") Long nodeId, @Param("enterpriseId") Long enterpriseId, @Param("updateUser") Long updateUser);

    List<TDdmWorkflowTemplateDetailApproveDraft> selectByNodeId(Long nodeId);
    List<TDdmWorkflowTemplateDetailApproveDraft> selectByNodeIdAndEnterpriseId(@Param("nodeId") Long nodeId, @Param("enterpriseId") Long enterpriseId);

    int logicDeleteByCondition(TDdmWorkflowTemplateDetailApproveDraft draftDelete);

}