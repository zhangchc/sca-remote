package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Map;

@Data
public class BatchInsertItemPO {
    Long id;
    Map<String, Object> fieldValue;
    String tableName;
}
