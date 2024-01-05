package com.phoenix.sca.mapper.pay;

import com.phoenix.sca.entity.pay.BusPayPre;
import com.phoenix.sca.entity.pay.BusPayPreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusPayPreMapper {
    long countByExample(BusPayPreExample example);

    int deleteByExample(BusPayPreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BusPayPre record);

    int insertSelective(BusPayPre record);

    List<BusPayPre> selectByExample(BusPayPreExample example);

    BusPayPre selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BusPayPre record, @Param("example") BusPayPreExample example);

    int updateByExample(@Param("record") BusPayPre record, @Param("example") BusPayPreExample example);

    int updateByPrimaryKeySelective(BusPayPre record);

    int updateByPrimaryKey(BusPayPre record);
}