package com.zhang.sca.common.enums;


public enum BizErrorCode {

    NO_STORE_ERROR("10001008", "请先选择门店"),

    FILE_UPLOAD_ERROR("10001007", "文件上传失败"),

    STORE_TYPE_ERROR("10001006", "店铺类型错误"),

    ARUGMENT_IS_NULL("10001005", "参数不能为空"),

    CREDIT_NO_ERROR("10001004", "统一信用代码格式不正确"),

    MOBILE_ERROR("10001003", "手机号格式不正确"),

    EDIT_ERROR("10001002", "编辑失败"),

    ARUGMENT_ERROR("10001001", "参数不正确");

    private String code;
    private String message;

    BizErrorCode(String code, String message) {
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
