package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmTableMetadata;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmTableMetadataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TDdmTableMetadata record);

    int insertSelective(TDdmTableMetadata record);

    TDdmTableMetadata selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmTableMetadata record);

    int updateByPrimaryKey(TDdmTableMetadata record);

    int batchInsert(@Param("list") List<TDdmTableMetadata> list);

    List<TDdmTableMetadata> selectTableMetadataByMetaId(Long metaId);

    int deleteTableMetaByMetaId(Long metaId);
}