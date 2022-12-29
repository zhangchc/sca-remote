package com.zhang.sca.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @author wangyuanchun
 *
 * @param <T>
 */
@Data
public class LegoPageResponseData<T> implements Serializable {
    /**
     * data
     */
    private T result;
    /**
     * 总条数
     */
    private Integer total;
}