package com.zhang.sca.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_ddm_page_info")
public class TDdmPageInfo {
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
     * app_id
     * 应用ID
     */
    private Long appId;

    /**
     * page_name
     * Page名称
     */
    private String pageName;

    /**
     * page_icon
     * Page图标
     */
    private String pageIcon;

    /**
     * page_desc
     * Page描述
     */
    private String pageDesc;

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
