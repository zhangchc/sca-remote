package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class TDdmAppInfo {
    /**
     * id
     * 
     */
    private Long id;

    /**
     * app_name
     * 应用名称
     */
    private String appName;

    /**
     * app_icon
     * 应用图标
     */
    private String appIcon;

    /**
     * app_desc
     * 应用描述
     */
    private String appDesc;

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 可见范围类型 1-工作区可见，2-指定成员可见（默认管理员可见）
     */
    private Integer rangeType;

    /**
     * create_user
     * 创建用户
     */
    private Long createUser;

    /**
     * create_date
     * 创建日期
     */
    private Date createTime;

    /**
     * update_user
     * 更新用户
     */
    private Long updateUser;

    /**
     * update_date
     * 更新日期
     */
    private Date updateTime;

    /**
     * is_delete
     * 逻辑删除(0未删除 1删除)
     */
    private Integer isDeleted;

}