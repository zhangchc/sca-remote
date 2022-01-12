package com.zhang.sca.mapper;

import com.zhang.sca.model.po.TDdmMetadata;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmMetadataMapper {

    int insert(TDdmMetadata record);

    int insertSelective(TDdmMetadata record);

    TDdmMetadata selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TDdmMetadata record);

    int updateByPrimaryKey(TDdmMetadata record);

    int batchInsert(@Param("list") List<TDdmMetadata> list);

    List<TDdmMetadata> getTDdMetadataByFormId(long formId);

    List<TDdmMetadata> getTDdMetadataByFormIdAndEnterpriseId(@Param("formId") long formId, @Param("enterpriseId") long enterpriseId);

    int pseudoDeleteMetadata(long id);

    int pseudoDeleteMetadataByFormId(@Param("formId") long formId, @Param("enterpriseId") long enterpriseId);
    int pseudoBatchDeleteMetaDataByFormId(@Param("ids") List<Long> formIds);
    int pseudoBatchDeleteMetaData(@Param("list") List<Long> ids);


}
