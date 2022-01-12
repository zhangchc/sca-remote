package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmWorkflowTemplateDetailApprove;
import org.apache.ibatis.annotations.Param;

public interface TDdmWorkflowTemplateDetailApproveMapper extends ExpandBaseMapper<TDdmWorkflowTemplateDetailApprove> {
    int deleteByPrimaryKey(Long id);

    @Override
    int insert(TDdmWorkflowTemplateDetailApprove record);

    int insertSelective(TDdmWorkflowTemplateDetailApprove record);

    TDdmWorkflowTemplateDetailApprove selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmWorkflowTemplateDetailApprove record);

    int updateByPrimaryKey(TDdmWorkflowTemplateDetailApprove record);

    int batchInsert(@Param("list") java.util.List<TDdmWorkflowTemplateDetailApprove> list);
}