package com.zhang.sca.facade.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述:接口输入类
 *
 * @author zhangchuancun
 * @date 2022/12/28 15:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoRequest implements Serializable {
    private Long userId;

    private String username;

    private String nickName;

    private String gender;
    /**
     * 页号
     */
    private Integer pageNo;
    /**
     * 页大小
     */
    private Integer pageSize;
}
