package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class TDdmWorkflowProcessDetail {
    /**
     * id
     */
    private Long id;

    /**
     * 企业id
     */
    private Long enterpriseId;

    /**
     * process_id
     * 处理进程id
     */
    private Long processId;

    /**
     * current_user_node_status
     * 当前人节点处理状态：1.未处理；2.已处理；3.忽略掉（或签状态下其他人处理）
     */
    private Integer currentUserNodeStatus;

    /**
     * process_user_id
     * 节点处理用户id
     */
    private Long processUserId;

    /**
     * process_time
     * 创建日期
     */
    private Date processTime;

    /**
     * is_deleted
     * 逻辑删除(0未删除 1删除)
     */
    private Boolean isDeleted;

}