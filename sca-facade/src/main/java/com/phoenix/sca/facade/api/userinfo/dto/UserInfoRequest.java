package com.phoenix.sca.facade.api.userinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

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

    private Long deptId;

    private String username;

    private String nickName;

    private String gender;

    private String phone;

    private String email;

    private String avatarName;

    private String avatarPath;

    private String password;

    private Boolean isAdmin;

    private Long enabled;

    private String createBy;

    private String updateBy;

    private Date pwdResetTime;

    /**
     * 页号
     */
    private Integer pageNo;
    /**
     * 页大小
     */
    private Integer pageSize;
}
