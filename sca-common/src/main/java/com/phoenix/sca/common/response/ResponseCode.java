package com.phoenix.sca.common.response;

public enum ResponseCode {
    SUCCESS_CODE("1", "成功"),
    PARAM_ERROR_CODE("1001","参数异常"),
    SYS_ERROR_CODE("500","系统异常"),

    USER_ERROR_RELOGIN_CODE("20001","登录过期请重新登录"),
    USER_LOGIN_CODE1("20002","用户名或密码错误"),
    USER_LOGIN_CODE2("20003","用户不存在"),
    USER_LOGIN_CODE3("20004","用户铁定出事了");

    private String code;
    private String message;
    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
