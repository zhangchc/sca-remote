package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class TDdmWorkflowTemplateDetail {
    /**
     * id
     */
    private Long id;

    /**
     * work_flow_temp_id
     * 工作流模板id
     */
    private Long workFlowTempId;
    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * parent_id
     * 父节点id,多个用"|"分开
     */
    private String parentId;

    /**
     * node_approve
     * 节点审批人
     */
    private String nodeApprove;

    /**
     * buss_type
     * 业务类型：1.审批节点；2.抄送节点；3.填写节点；4.子分支节点
     */
    private Integer bussType;

    /**
     * node_type
     * 1.发起节点；2.过程节点；3.结束节点；4.即是开始又是结束
     */
    private Integer nodeType;

    /**
     * node_name
     * 节点名称
     */
    private String nodeName;

    /**
     * node_expr
     * 节点表达式
     */
    private String nodeExpr;

    /**
     * approve_type
     * 审批类型 1：会签；2:或签
     */
    private Integer approveType;

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