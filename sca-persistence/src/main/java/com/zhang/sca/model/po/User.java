package com.zhang.sca.model.po;

import lombok.Data;

import java.util.Date;
@Data
public class User {
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

    private Date createTime;

    private Date updateTime;
}