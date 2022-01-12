package com.zhang.sca.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_ddm_dict_address")
public class TDdmDictAddress {
    /**
     * id
     * 
     */
    private Long id;

    /**
     * code
     * 编码
     */
    private String code;

    /**
     * name
     * 名称
     */
    private String name;

    /**
     * pinyin
     * 拼音前缀
     */
    private String pinyin;

    /**
     * level
     * 级别 1:省份 2:市 3:区 4:镇
     */
    private Integer level;

    /**
     * parent_code
     * 上级编码
     */
    private String parentCode;

    /**
     * version
     * 版本号 更新时间戳
     */
    private Long version;

    /**
     * create_time
     * 
     */
    private Date createTime;

    /**
     * is_deleted
     * 是否删除 1删除 0未删除
     */
    private Boolean isDeleted;

    /**
     * is_overseas
     * 是否海外：0否，1是
     */
    private Boolean isOverseas;
}