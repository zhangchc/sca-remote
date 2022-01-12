package com.zhang.sca.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_ddm_administrator")
public class TDdmAdministrator {
    /**
     * id
     *
     */
    private Long id;

    /**
     * enterprise_id
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * user_id
     *
     */
    private Long userId;

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
     * is_enterprise_owner
     * 企业工作区拥有者（0 否，1是）
     */
    private Boolean isEnterpriseOwner;

    /**
     * is_deleted
     * 逻辑删除(0未删除 1删除)
     */
    private Boolean isDeleted;
}
