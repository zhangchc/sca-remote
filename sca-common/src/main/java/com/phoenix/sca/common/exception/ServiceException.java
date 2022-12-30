package com.phoenix.sca.common.exception;

/**
 * 描述:
 *
 * @author zhangchuancun
 * @date 2022/12/29 19:31
 */
public class ServiceException extends RuntimeException {
    private String code;
    private String message;

    public ServiceException() {
    }

    public ServiceException(String code, String message, Throwable cause) {
        super(code + ":" + message, cause);
        this.code = code;
        this.message = message;
    }

    public ServiceException(String code, String message) {
        super(code + ":" + message);
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
