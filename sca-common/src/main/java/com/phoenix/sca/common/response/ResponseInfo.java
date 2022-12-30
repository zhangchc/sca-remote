package com.phoenix.sca.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInfo<T> implements Serializable {

    private Integer ret;

    private String msg;

    private T data;

    public boolean successful() {
        return BizResponseStatus.SUCCESS_CODE.equals(ret);
    }

    public static <T> ResponseInfo<T> success(T data) {
        return new ResponseInfo<>(BizResponseStatus.SUCCESS_CODE, "success", data);
    }

    public static <T> ResponseInfo<T> success() {
        return new ResponseInfo<>(BizResponseStatus.SUCCESS_CODE, "success", null);
    }

    public static <T> ResponseInfo<T> fail(int code, String msg, T data) {
        return new ResponseInfo<>(code, msg, null);
    }

    public static <T> ResponseInfo<T> paramError(String msg) {
        return new ResponseInfo<>(BizResponseStatus.PARAM_ERROR_CODE, msg, null);
    }

    public static <T> ResponseInfo<T> paramError() {
        return new ResponseInfo<>(BizResponseStatus.PARAM_ERROR_CODE, "参数错误", null);
    }

    public static <T> ResponseInfo<T> systemError(String msg) {
        return new ResponseInfo<>(BizResponseStatus.PARAM_ERROR_CODE, msg, null);
    }

    public static <T> ResponseInfo<T> systemError() {
        return new ResponseInfo<>(BizResponseStatus.PARAM_ERROR_CODE, "系统错误", null);
    }

    public static <T> ResponseInfo<T> build(int code, String msg, T data) {
        return new ResponseInfo<>(code, msg, data);
    }
}
