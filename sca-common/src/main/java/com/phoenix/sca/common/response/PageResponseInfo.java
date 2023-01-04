package com.phoenix.sca.common.response;

import lombok.Data;

import java.io.Serializable;


@Data
public class PageResponseInfo<T> implements Serializable {
    /**
     * 状态码
     */
    private String ret;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private PageResponseData<T> data = new PageResponseData<>();

    public PageResponseInfo() {
    }

    public PageResponseInfo(String ret, String msg, T data) {
        this.ret = ret;
        this.msg = msg;
        this.data.setResult(data);
    }

    public PageResponseInfo(String ret, String msg, T data, Integer total) {
        this.ret = ret;
        this.msg = msg;
        this.data.setResult(data);
        this.data.setTotal(total);
    }

    public static <T> PageResponseInfo<T> success(T data, Integer total) {
        return new PageResponseInfo<>("1", "success", data, total);
    }


    public static <T> PageResponseInfo<T> success() {
        return new PageResponseInfo<>("1", "success", null);
    }

    public static <T> PageResponseInfo<T> paramError(String msg) {
        return new PageResponseInfo<>(ResponseCode.PARAM_ERROR_CODE.getCode(), msg, null);
    }

    public static <T> PageResponseInfo<T> paramError() {
        return new PageResponseInfo<>(ResponseCode.PARAM_ERROR_CODE.getCode(), "参数错误", null);
    }

    public static <T> PageResponseInfo<T> systemError(String msg) {
        return new PageResponseInfo<>(ResponseCode.SYS_ERROR_CODE.getCode(), msg, null);
    }

    public static <T> PageResponseInfo<T> systemError() {
        return new PageResponseInfo<>(ResponseCode.SYS_ERROR_CODE.getCode(), "系统错误", null);
    }

    public static <T> PageResponseInfo<T> build(String ret, String msg, T data) {
        return new PageResponseInfo<>(ret, msg, data);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LegoPageResponseInfoDTO{");
        sb.append("ret=").append(this.getRet());
        sb.append(", msg=").append(this.getMsg());
        sb.append(", data=").append(this.getData());
        sb.append(", total=").append(this.getData().getTotal());
        sb.append('}');
        return sb.toString();
    }

}
