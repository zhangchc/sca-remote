package com.phoenix.sca.facade.api.sysdept.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/1/9 13:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysDeptRequest implements Serializable {

    private Long deptId;

    private Long pid;

    private Integer subCount;

    private String name;

    private Integer deptSort;

    private Boolean enabled;
    /**
     * 页号
     */
    private Integer pageNo;
    /**
     * 页大小
     */
    private Integer pageSize;
}
