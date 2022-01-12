package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmFormDataUpdateRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmFormDataUpdateRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TDdmFormDataUpdateRecord record);

    int insertSelective(TDdmFormDataUpdateRecord record);

    TDdmFormDataUpdateRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmFormDataUpdateRecord record);

    int updateByPrimaryKey(TDdmFormDataUpdateRecord record);

    int batchInsert(@Param("list") List<TDdmFormDataUpdateRecord> list);

}