package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmWorkflowTemplate;
import org.apache.ibatis.annotations.Param;

public interface TDdmWorkflowTemplateMapper {

    int insert(TDdmWorkflowTemplate record);

    int insertSelective(TDdmWorkflowTemplate record);

    TDdmWorkflowTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmWorkflowTemplate record);

    int updateByPrimaryKey(TDdmWorkflowTemplate record);

    int updatePublishedExpired(@Param("pageId") Long formId, @Param("enterpriseId") Long enterpriseId);

    int batchInsert(@Param("list") java.util.List<TDdmWorkflowTemplate> list);
}
