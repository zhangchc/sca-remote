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
@TableName("t_ddm_form_record")
public class TDdmFormRecord {
    /**
     * id
     * 
     */
    private Integer id;

    /**
     * formId
     * 
     */
    private Integer formId;
    /**
     * 企业id
     */
    private Long enterpriseId;

    /**
     * src_content
     * 
     */
    private String srcContent;

    /**
     * target_content
     * 
     */
    private String targetContent;

    /**
     * create_time
     * 记录时间
     */
    private Date createTime;

}