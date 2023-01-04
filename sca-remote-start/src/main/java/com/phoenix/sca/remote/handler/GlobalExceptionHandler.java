package com.phoenix.sca.remote.handler;

import com.phoenix.sca.common.exception.ServiceException;
import com.phoenix.sca.common.response.ResponseCode;
import com.phoenix.sca.common.response.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Description 统一异常处理
 * @Author hubin1
 * @Date 2022-10-19
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseInfo<?> defaultErrorHandler(Exception e, HttpServletRequest request) {
        log.error("GlobalExceptionHandler:访问url:[{}],[{}],[{}]", request.getRequestURI(), e.getMessage(), e);
        return ResponseInfo.build(ResponseCode.SYS_ERROR_CODE.getCode(), "系统出现异常", null);
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseInfo<?> noHandlerFoundException(Exception e, HttpServletRequest request) {
        log.error("GlobalExceptionHandler:访问url:[{}],[{}],[{}]", request.getRequestURI(), e.getMessage(), e);
        return ResponseInfo.build(ResponseCode.PARAM_ERROR_CODE.getCode(), "参数异常", null);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseInfo<?> illegalArgumentException(Exception e, HttpServletRequest request) {
        log.error("GlobalExceptionHandler:访问url:[{}],[{}],[{}]", request.getRequestURI(), e.getMessage(), e);
        return ResponseInfo.build(ResponseCode.PARAM_ERROR_CODE.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler(value = ServiceException.class)
    public ResponseInfo<?> noHandlerFoundException(ServiceException e, HttpServletRequest request) {
        log.error("GlobalExceptionHandler:访问url:[{}],[{}],[{}]", request.getRequestURI(), e.getMessage(), e);
        return ResponseInfo.build(e.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseInfo<?> validateBindException(BindException e, HttpServletRequest request) {
        log.error("GlobalExceptionHandler:访问url:[{}],[{}],[{}]", request.getRequestURI(), e.getMessage(), e);
        BindingResult result = e.getBindingResult();
        String errorMessage = "参数不正确";
        if (result.hasErrors()) {
            errorMessage = Objects.requireNonNull(result.getFieldError()).getDefaultMessage();
        }
        return ResponseInfo.build(ResponseCode.PARAM_ERROR_CODE.getCode(), errorMessage, null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseInfo<?> handleValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("GlobalExceptionHandler:访问url:[{}],[{}],[{}]", request.getRequestURI(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage(), e);
        log.error(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return ResponseInfo.build(ResponseCode.PARAM_ERROR_CODE.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage(), null);
    }
}
