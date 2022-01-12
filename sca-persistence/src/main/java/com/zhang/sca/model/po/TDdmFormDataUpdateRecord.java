package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class TDdmFormDataUpdateRecord {
    /**
     * id
     * id
     */
    private Long id;

    /**
     * form_id
     * 表单id
     */
    private Long formId;

    /**
     * enterpriseId
     */
    private Long enterpriseId;

    /**
     * data_id
     * 表单数据id
     */
    private Long dataId;

    /**
     * process_record_id
     * 流程记录id
     */
    private Long processRecordId;

    /**
     * field_name
     * 字段名称
     */
    private String fieldName;

    /**
     * field_old_value
     * 该字段旧值
     */
    private String fieldOldValue;

    /**
     * field_new_value
     * 该字段新值
     */
    private String fieldNewValue;

    /**
     * update_user_id
     * 修改用户id
     */
    private Long updateUserId;

    /**
     * create_time
     * 创建时间
     */
    private Date createTime;

    /**
     * update_time
     * 
     */
    private Date updateTime;

}