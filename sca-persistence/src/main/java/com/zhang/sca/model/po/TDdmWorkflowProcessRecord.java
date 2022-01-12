package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class TDdmWorkflowProcessRecord {
    /**
     * id
     */
    private Long id;

    /**
     * form_id
     */
    private Long formId;

    /**
     * 企业id
     */
    private Long enterpriseId;

    /**
     * data_id
     * 数据id
     */
    private Long dataId;

    /**
     * temp_id
     * 模板id
     */
    private Long tempId;

    /**
     * node_id
     * 节点id
     */
    private Long nodeId;

    private Long pageId;
    /**
     * node_name
     * 节点名称
     */
    private String nodeName;

    /**
     * approve_status
     * 审批状态：1.通过；2.不通过
     */
    private Integer approveStatus;

    /**
     * approve_user_id
     * 审批人
     */
    private Long approveUserId;

    /**
     * approve_desc
     * 审批意见
     */
    private String approveDesc;

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