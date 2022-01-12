package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class TDdmWorkflowProcess {
    /**
     * id
     */
    private Long id;

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * form_id
     * 表单id
     */
    private Long formId;

    /**
     * node_id
     * 节点id
     */
    private Long nodeId;

    /**
     * data_id
     * 数据id
     */
    private Long dataId;


    private Long pageId;
    /**
     * approve_type
     * 审批类型 1：会签；2:或签
     */
    private Integer approveType;

    /**
     * node_status
     * 节点处理状态：1.未处理；2.已处理；
     */
    private Integer nodeStatus;

    /**
     * node_name
     * 节点显示名称
     */
    private String nodeName;

    /**
     * create_time
     * 创建日期
     */
    private Date createTime;

    /**
     * is_deleted
     * 逻辑删除(0未删除 1删除)
     */
    private Boolean isDeleted;

}
