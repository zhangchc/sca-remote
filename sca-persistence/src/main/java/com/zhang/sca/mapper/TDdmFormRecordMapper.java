package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmFormRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmFormRecordMapper {

    int insert(TDdmFormRecord record);

    int insertSelective(TDdmFormRecord record);

    TDdmFormRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDdmFormRecord record);

    int updateByPrimaryKey(TDdmFormRecord record);

    int batchInsert(@Param("list") List<TDdmFormRecord> list);

}
