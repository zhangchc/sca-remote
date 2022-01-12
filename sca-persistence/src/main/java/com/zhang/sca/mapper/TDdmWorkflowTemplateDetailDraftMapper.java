package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmWorkflowTemplateDetailDraft;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmWorkflowTemplateDetailDraftMapper {
    int insert(TDdmWorkflowTemplateDetailDraft record);

    int insertSelective(TDdmWorkflowTemplateDetailDraft record);

    TDdmWorkflowTemplateDetailDraft selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmWorkflowTemplateDetailDraft record);

    int updateByPrimaryKey(TDdmWorkflowTemplateDetailDraft record);

    int batchInsert(@Param("list") List<TDdmWorkflowTemplateDetailDraft> list);

    List<TDdmWorkflowTemplateDetailDraft> selectByWorkFlowTempId(Long id);

    List<TDdmWorkflowTemplateDetailDraft> selectByWorkFlowTempIdAndEnterpriseId(@Param("WorkFlowTempId") Long WorkFlowTempId, @Param("enterpriseId") Long enterpriseId);

    TDdmWorkflowTemplateDetailDraft selectByPrimaryKeyAndEnterpriseId(@Param("id") long id, @Param("enterpriseId") Long enterpriseId);

    List<TDdmWorkflowTemplateDetailDraft> selectByParentIdAndEnterpriseId(@Param("parentId") String parentId, @Param("enterpriseId") Long enterpriseId);

    TDdmWorkflowTemplateDetailDraft selectFirstByTemplateIdAndEnterpriseId(@Param("workFlowTempId") Long workFlowTempId, @Param("enterpriseId") Long enterpriseId);
}
