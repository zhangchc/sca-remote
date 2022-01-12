package com.zhang.sca.mapper;

import com.zhang.sca.model.po.DynFormDDLData;
import com.zhang.sca.model.po.TDdmFormInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDdmFormInfoMapper {

    int insert(TDdmFormInfo record);

    int insertSelective(TDdmFormInfo record);

    TDdmFormInfo selectByPrimaryKey(Long id);

    /**
     * 根据主键id查询数据（附带企业id）
     * @param formInfo
     * @return
     */
    TDdmFormInfo selectByPrimaryKeyAndEnterpriseId(TDdmFormInfo formInfo);


    /**
     * 根据paged查询数据（附带企业id）
     * @param formInfo
     * @return
     */
    TDdmFormInfo selectByPageIdAndEnterpriseId(TDdmFormInfo formInfo);
    int updateByPrimaryKeySelective(TDdmFormInfo record);

    int updateByPrimaryKey(TDdmFormInfo record);

    int batchInsert(@Param("list") List<TDdmFormInfo> list);

    int pseudoDeleteFormInfo(@Param("id")Long id, @Param("enterpriseId")Long enterpriseId);

    int pseudoDeleteFormInfoByPageId(@Param("pageId")Long pageId,@Param("enterpriseId")Long enterpriseId);

    //List<TDdmFormInfo> selectByProcessPendingUserId(Long currentUserId);

    int createDynFormTable(@Param("ddl")DynFormDDLData ddl);

    int alterDynFormTable(@Param("ddl")DynFormDDLData ddl);

    long dynFormTableExist(String tableName);

    List<TDdmFormInfo> getFormInfoByPageIds(@Param("ids")List<Long>  pageIds, @Param("enterpriseId") long enterpriseId);

    List<TDdmFormInfo> getFormInfoByAppId(@Param("appId")Long appId, @Param("start")int start, @Param("size")int size);

    List<TDdmFormInfo> getFormInfoByAppIdAndEnterpriseId(@Param("appId")Long appId, @Param("enterpriseId")Long enterpriseId, @Param("start")int start, @Param("size")int size);

    List<TDdmFormInfo> selectByProcessPendingUserIdAndEnterpriseId(@Param("processUserId") Long processUserId, @Param("enterpriseId")Long enterpriseId);
    int pseudoBatchDeleteFormInfoByPageId(@Param("list") List<Long> ids, @Param("enterpriseId") long enterpriseId);
}
