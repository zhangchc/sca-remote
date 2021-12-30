package com.zhang.sca.model.po;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class FormDataPO {
    /**
     * 主键id
     */
    private Long dataId;
    /**
     * enterpriseId
     */
    private Long enterpriseId;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 参数
     */
    private Map<String, Object> addMap;
    /**
     * 参数
     */
    private Map<String, Object> editMap;
    /**
     * 参数
     */
    private Map<String, List<Object>> queryMap;
    /**
     * 字段，逗号隔开
     */
    private List<Map<String, Object>> batchInsertMap;
    private List<String> headers;
    private List<Object> columns;

    private Integer workflowStatus;

    private Integer pageNum;

    private Integer pageSize;
}
