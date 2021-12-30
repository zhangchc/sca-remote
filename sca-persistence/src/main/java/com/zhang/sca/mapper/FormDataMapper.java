package com.zhang.sca.mapper;

import com.zhang.sca.model.po.FormDataPO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FormDataMapper {

    ArrayList<HashMap<String,Object>> getFormData(@Param("tableName") String tableName, @Param("ids") List<Long> ids);

}
