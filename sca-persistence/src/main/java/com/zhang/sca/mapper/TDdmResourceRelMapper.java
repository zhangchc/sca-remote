package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmResourceRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmResourceRelMapper extends ExpandBaseMapper<TDdmResourceRel> {

    int insert(TDdmResourceRel record);

    int updateByPrimaryKeySelective(TDdmResourceRel record);

    int batchInsert(@Param("list") List<TDdmResourceRel> list);

}