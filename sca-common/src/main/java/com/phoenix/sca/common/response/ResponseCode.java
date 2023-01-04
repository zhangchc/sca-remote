package com.phoenix.sca.common.response;

public enum ResponseCode {
    SUCCESS_CODE("1", "成功"),
    PARAM_ERROR_CODE("1001","参数异常"),
    SYS_ERROR_CODE("500","系统异常");
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
