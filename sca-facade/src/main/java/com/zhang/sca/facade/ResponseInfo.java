package com.zhang.sca.facade;

import com.zhang.sca.common.constants.DdmConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInfo<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public boolean isSuccess() {
        return DdmConstants.SUCCESS_CODE.equals(code);
    }

    public static <T> ResponseInfo<T> success(T data) {
        return new ResponseInfo<>(DdmConstants.SUCCESS_CODE,"success",data);
    }

    public static <T> ResponseInfo<T> success() {
        return new ResponseInfo<>(DdmConstants.SUCCESS_CODE,"success",null);
    }

    public static <T> ResponseInfo<T> fail(String msg) {
        return new ResponseInfo<>(DdmConstants.SUCCESS_CODE,msg,null);
    }

    public static <T> ResponseInfo<T> paramError(String msg) {
        return new ResponseInfo<>(DdmConstants.PARAM_ERROR_CODE,msg,null);
    }

    public static <T> ResponseInfo<T> paramError() {
        return new ResponseInfo<>(DdmConstants.PARAM_ERROR_CODE,"参数错误",null);
    }

    public static <T> ResponseInfo<T> systemError(String msg) {
        return new ResponseInfo<>(DdmConstants.PARAM_ERROR_CODE,msg,null);
    }

    public static <T> ResponseInfo<T> systemError() {
        return new ResponseInfo<>(DdmConstants.PARAM_ERROR_CODE,"系统错误",null);
    }

    public static <T> ResponseInfo<T> build(int code, String msg, T data) {
        return new ResponseInfo<>(code,msg,data);
    }

}
