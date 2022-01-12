package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class TDdmWorkflowTemplateDetailApprove {
    /**
     * id
     * 主键
     */
    private Long id;

    /**
     * node_id
     * 流程模板明细表id
     */
    private Long nodeId;

    /**
     * enterprise_id
     * 
     */
    private Long enterpriseId;

    /**
     * belong_id
     * 审批归属id
     */
    private Long belongId;

    /**
     * belong_type
     * 审批归属类型：1-部门，2-人员，3-角色
     */
    private Integer belongType;

    /**
     * create_user
     * 创建用户
     */
    private Long createUser;

    /**
     * create_time
     * 创建日期
     */
    private Date createTime;

    /**
     * update_user
     * 更新用户
     */
    private Long updateUser;

    /**
     * update_time
     * 更新日期
     */
    private Date updateTime;

    /**
     * is_deleted
     * 逻辑删除(0未删除 1删除)
     */
    private Boolean isDeleted;

}