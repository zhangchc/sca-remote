package com.phoenix.sca.facade.api.sysdept.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @date 2024/1/9 13:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysDeptResponse implements Serializable {
    private Long deptId;

    private Long pid;

    private Integer subCount;

    private String name;

    private Integer deptSort;

    private Boolean enabled;

    private String createBy;

    private String updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
