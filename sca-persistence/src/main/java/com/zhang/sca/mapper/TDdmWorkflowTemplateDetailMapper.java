package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmWorkflowTemplateDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmWorkflowTemplateDetailMapper {

    int insert(TDdmWorkflowTemplateDetail record);

    int insertSelective(TDdmWorkflowTemplateDetail record);

    TDdmWorkflowTemplateDetail selectByPrimaryKey(Long id);
    TDdmWorkflowTemplateDetail selectByPrimaryKeyAndEnterpriseId(@Param("id")Long id, @Param("enterpriseId") Long enterpriseId);

    int updateByPrimaryKeySelective(TDdmWorkflowTemplateDetail record);

    int updateByPrimaryKey(TDdmWorkflowTemplateDetail record);

    int batchInsert(@Param("list") List<TDdmWorkflowTemplateDetail> list);

    TDdmWorkflowTemplateDetail selectRootNodeInfoByFormId(Long formId);

    List<TDdmWorkflowTemplateDetail> selectNodeByParentId(@Param("parentId") String parentId, @Param("workFlowTempId") Long workFlowTempId, @Param("enterpriseId") Long enterpriseId);

    List<TDdmWorkflowTemplateDetail> selectByFormIdAndParentIdIsNull(Long formId);

    List<TDdmWorkflowTemplateDetail> selectByPageIdAndParentIdIsNull(Long page);

    TDdmWorkflowTemplateDetail selectRootNodeInfoByFormIdAndEnterpriseId(@Param("formId") Long formId, @Param("enterpriseId") Long enterpriseId);
    List<TDdmWorkflowTemplateDetail> selectByParentIdAndEnterpriseId(@Param("parentId") String parentId, @Param("enterpriseId") Long enterpriseId);
    TDdmWorkflowTemplateDetail selectRootNodeInfoByPageIdAndEnterpriseId(@Param("pageId") Long pageId, @Param("enterpriseId") Long enterpriseId);
}
