package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmWorkflowTemplateDraft;
import org.apache.ibatis.annotations.Param;

public interface TDdmWorkflowTemplateDraftMapper {

    int insert(TDdmWorkflowTemplateDraft record);

    int insertSelective(TDdmWorkflowTemplateDraft record);

    TDdmWorkflowTemplateDraft selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmWorkflowTemplateDraft record);

    int updateByPrimaryKey(TDdmWorkflowTemplateDraft record);

    int batchInsert(@Param("list") java.util.List<TDdmWorkflowTemplateDraft> list);

    TDdmWorkflowTemplateDraft selectByFormId(Long formId);

    TDdmWorkflowTemplateDraft selectByFormIdAndEnterpriseId(@Param("formId") Long formId, @Param("enterpriseId") Long enterpriseId);

    TDdmWorkflowTemplateDraft selectByPageIdAndEnterpriseId(@Param("pageId") Long pageId, @Param("enterpriseId") Long enterpriseId);

    TDdmWorkflowTemplateDraft selectByPrimaryKeyAndEnterpriseId(@Param("workFlowTempId") Long workFlowTempId, @Param("enterpriseId") Long enterpriseId);
}
