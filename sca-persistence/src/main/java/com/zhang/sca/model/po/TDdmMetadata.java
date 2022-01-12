package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TDdmMetadata {
    /**
     * id
     * 
     */
    private Long id;

    /**
     * form_id
     * form表单ID
     */
    private Long formId;

    /**
     * enterpriseId
     */
    private Long enterpriseId;

    /**
     * column_field
     * 列名
     */
    private String columnField;

    /**
     * column_type
     * 类型
     */
    private String columnType;

    /**
     * column_desc
     * 描述
     */
    private String columnDesc;

    /**
     * max_length
     * 最大长度
     */
    private Integer maxLength;

    /**
     * min_length
     * 最小长度
     */
    private Integer minLength;

    /**
     * 前端组件类型
     */
    private String componentType;

    private String remark;

    private int componentOrder;

    /**
     * default_value
     * 默认值
     */
    private String defaultValue;

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

    private Boolean required;

    /**
     * is_deleted
     * 逻辑删除(0未删除 1删除)
     */
    private String[] options;

    private Boolean isDeleted;

    private List<TDdmTableMetadata> tableMeta;

}