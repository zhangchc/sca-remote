package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmWorkflowProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmWorkflowProcessMapper {

    List<TDdmWorkflowProcess> selectByUserIdAndFormId(@Param("formId") Long formId,@Param("processUserId") Long processUserId , @Param("enterpriseId")Long enterpriseId);

    List<TDdmWorkflowProcess> selectByUserIdAndPageId(@Param("pageId") Long pageId,@Param("processUserId") Long processUserId, @Param("enterpriseId")Long enterpriseId );

    int insert(TDdmWorkflowProcess record);

    long insertSelective(TDdmWorkflowProcess record);

    TDdmWorkflowProcess selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmWorkflowProcess record);

    int updateByPrimaryKey(TDdmWorkflowProcess record);

    int batchInsert(@Param("list") List<TDdmWorkflowProcess> list);

    TDdmWorkflowProcess selectByFormIdAndDataIdAndEnterpriseId(@Param("formId") Long formId, @Param("dataId") Long dataId, @Param("enterpriseId") Long enterpriseId);
    TDdmWorkflowProcess selectByPageIdAndDataIdAndEnterpriseId(@Param("pageId") Long pageId, @Param("dataId") Long dataId, @Param("enterpriseId") Long enterpriseId);
    List<TDdmWorkflowProcess> selectByFormIdAndUserIdAndNodeStatus(@Param("enterpriseId") Long enterpriseId,
                                                                   @Param("formId") Long formId,
                                                                   @Param("userId") Long userId,
                                                                   @Param("nodeStatus") Integer nodeStatus,
                                                                   @Param("pageNum") Integer pageNum,
                                                                   @Param("pageSize") Integer pageSize);

    List<TDdmWorkflowProcess> selectByPageIdAndUserIdAndNodeStatus(@Param("enterpriseId") Long enterpriseId,
                                                                   @Param("pageId") Long pageId,
                                                                   @Param("userId") Long userId,
                                                                   @Param("nodeStatus") Integer nodeStatus,
                                                                   @Param("pageNum") Integer pageNum,
                                                                   @Param("pageSize") Integer pageSize);
    Long getProcessPendingCount( @Param("enterpriseId")Long enterpriseId, @Param("processUserId") Long processUserId);

    //Long getProcessPendingUserCount(@Param("formId") Long formId, @Param("nodeId") Long nodeId, @Param("dataId") Long dataId, @Param("enterpriseId")Long enterpriseId);

    Long getProcessPendingUserCount(@Param("pageId") Long pageId, @Param("nodeId") Long nodeId, @Param("dataId") Long dataId, @Param("enterpriseId")Long enterpriseId);

    //Long getProcessPendingNeedUserApprove(@Param("formId") Long formId, @Param("dataId") Long dataId, @Param("processUserId") Long processUserId, @Param("enterpriseId")Long enterpriseId);

    Long getProcessPendingNeedUserApprove(@Param("pageId") Long pageId, @Param("dataId") Long dataId, @Param("processUserId") Long processUserId, @Param("enterpriseId")Long enterpriseId);


    Long getWorkflowTmpId(@Param("pageId") Long pageId, @Param("dataId") Long dataId, @Param("enterpriseId") Long enterpriseId);

    int deleteWorkFlowByPageIdAndDataId(@Param("pageId") Long pageId, @Param("dataIds") List<Long> ids, @Param("enterpriseId") Long enterpriseId);

    int deleteWorkFlowOfPages(@Param("pageIds") List<Long> pageIds, @Param("enterpriseId") Long enterpriseId);
}
