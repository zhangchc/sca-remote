package com.zhang.sca.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_ddm_form_info")
public class TDdmFormInfo {
    /**
     * id
     * 
     */
    private Long id;

    /**
     * app_id
     * 
     */
    private Long appId;

    /**
     * form_name
     * 表单名称
     */
    private String formName;

    /**
     * form_desc
     * 表单描述
     */
    private String formDesc;

    /**
     * form_json
     * 前台传入的formjson
     */
    private String formJson;
    /**
     * form_json_md5
     * 前台传入的formjson
     */
    private String formJsonMd5;

    private String publishedFormJson;

    private String publishedFormJsonMd5;
    /**
     * 企业id
     */
    private Long  enterpriseId;

    private String publishedFormName;

    private String publishedFormDesc;

    private Long pageId;
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