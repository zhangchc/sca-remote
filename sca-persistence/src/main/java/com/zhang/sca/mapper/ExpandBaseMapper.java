package com.zhang.sca.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpandBaseMapper<T> extends BaseMapper<T> {

    /**
     * 以下定义的 4个 default method, copy from {@link com.baomidou.mybatisplus.extension.toolkit.ChainWrappers}
     */
    default QueryChainWrapper<T> queryChain() {
        return new QueryChainWrapper<>(this);
    }

    default LambdaQueryChainWrapper<T> lambdaQueryChain() {
        return new LambdaQueryChainWrapper<>(this);
    }

    default UpdateChainWrapper<T> updateChain() {
        return new UpdateChainWrapper<>(this);
    }

    default LambdaUpdateChainWrapper<T> lambdaUpdateChain() {
        return new LambdaUpdateChainWrapper<>(this);
    }

    /**
     * 以下定义的 4个 method 其中 3 个是内置的选装件
     */
    int insertBatchSomeColumn(List<T> entityList);

    int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);

    int deleteByIdWithFill(T entity);

    /**
     * 根据 entity 条件，查询一条记录
     *使用Limit 1
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    T selectFirst(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
}
