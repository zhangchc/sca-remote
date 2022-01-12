package com.zhang.sca.model.po;

import lombok.Data;

import java.util.List;

@Data
public class DynFormDDLData {
    Long formId;
    String tableName;

    List<TDdmMetadata> create;

    List<TDdmMetadata> add;

    List<TDdmMetadata> delete;

    List<TDdmMetadata> change;
}
