package com.zhang.sca.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_ddm_resource_rel")
public class TDdmResourceRel {
    /**
     * id
     * 主键
     */
    private Long id;

    /**
     * resource_id
     * 资源id
     */
    private Long resourceId;

    /**
     * enterprise_id
     * 企业id
     */
    private Long enterpriseId;

    /**
     * resource_type
     * 资源类型，1-应用，2-Page
     */
    private Integer resourceType;

    /**
     * belong_id
     * 归属id
     */
    private Long belongId;

    /**
     * belong_type
     * 归属类型：1-部门，2-人员，3-角色
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
