package com.zhang.sca.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_ddm_table_metadata")
public class TDdmTableMetadata {
    /**
     * id
     * 自增id
     */
    private Long id;

    /**
     * meta_id
     * 关联metadata id
     */
    private Long metaId;

    /**
     * column_title
     * 表头文本
     */
    private String columnTitle;

    /**
     * column_uuid
     * 表头uuid
     */
    private String columnUuid;

    /**
     * remark
     * 备注
     */
    private String remark;

    /**
     * column_type
     * 该列的数据类型，备用
     */
    private String columnType;

    /**
     * is_delete
     * 是否删除，0未删除 1已删除
     */
    private Boolean isDelete;

}