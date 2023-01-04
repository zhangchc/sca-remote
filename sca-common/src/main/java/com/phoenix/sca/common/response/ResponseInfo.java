package com.phoenix.sca.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInfo<T> implements Serializable {

    private String ret;

    private String msg;

    private T data;

    public boolean successful() {
        return ResponseCode.SUCCESS_CODE.getCode().equals(ret);
    }

    public static <T> ResponseInfo<T> success(T data) {
        return new ResponseInfo<>(ResponseCode.SUCCESS_CODE.getCode(), "success", data);
    }

    public static <T> ResponseInfo<T> success() {
        return new ResponseInfo<>(ResponseCode.SUCCESS_CODE.getCode(), "success", null);
    }

    public static <T> ResponseInfo<T> fail(String code, String msg, T data) {
        return new ResponseInfo<>(code, msg, null);
    }

    public static <T> ResponseInfo<T> paramError(String msg) {
        return new ResponseInfo<>(ResponseCode.PARAM_ERROR_CODE.getCode(), msg, null);
    }

    public static <T> ResponseInfo<T> paramError() {
        return new ResponseInfo<>(ResponseCode.PARAM_ERROR_CODE.getCode(), "参数错误", null);
    }

    public static <T> ResponseInfo<T> systemError(String msg) {
        return new ResponseInfo<>(ResponseCode.SYS_ERROR_CODE.getCode(), msg, null);
    }

    public static <T> ResponseInfo<T> systemError() {
        return new ResponseInfo<>(ResponseCode.SYS_ERROR_CODE.getCode(), "系统错误", null);
    }

    public static <T> ResponseInfo<T> build(String code, String msg, T data) {
        return new ResponseInfo<>(code, msg, data);
    }
}
