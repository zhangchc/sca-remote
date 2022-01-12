package com.zhang.sca.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@TableName("t_ddm_user_login_status")
public class TDdmUserLoginStatus {
    /**
     * id
     * 主键
     */
    private Long id;

    /**
     * user_id
     * 用户id
     */
    private Long userId;

    /**
     * enterprise_id
     * 用户最近登录企业id
     */
    private Long enterpriseId;

    /**
     * login_time
     * 用户最近登录企业时间
     */
    private Date loginTime;

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