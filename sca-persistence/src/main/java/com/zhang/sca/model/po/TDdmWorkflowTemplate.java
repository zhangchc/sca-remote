package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class TDdmWorkflowTemplate {
    /**
     * id
     */
    private Long id;

    /**
     * form_id
     * 表单id
     */
    private Long formId;
    private Long pageId;
    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 0未发布，1生效中，2已失效
     */
    private Integer isPublished;

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