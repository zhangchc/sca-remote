package com.phoenix.sca.remote.handler;

import com.phoenix.sca.common.config.CommonProperties;
import com.phoenix.sca.common.exception.ServiceException;
import com.phoenix.sca.common.response.ResponseCode;
import com.phoenix.sca.common.utils.JwtTokenUtil;
import com.phoenix.sca.common.utils.ThreadLocalHelp;
import com.phoenix.sca.facade.api.userinfo.UserInfoService;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoRequest;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter implements Ordered {

    @Resource
    private CommonProperties commonProperties;

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserInfoService userInfoService;
    /**
     * 在一个请求进入Controller层方法执行前执行这个方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("请求地址:{}", requestURI);
        if ("OPTIONS".equals(request.getMethod())) {
            log.info("OPTIONS请求AuthInterceptor");
            return true;
        }
        String platformType = this.loginCheck(handler, requestURI);
        if (StringUtils.isNotBlank(platformType)) {
            String authToken = request.getHeader(commonProperties.getJwt().getTokenHeader());
            if (authToken != null) {
                String userName = (String) jwtTokenUtil.getValueFromToken(authToken, JwtTokenUtil.CLAIM_KEY_USER_NAME);
                Integer userId =  (Integer)jwtTokenUtil.getValueFromToken(authToken, JwtTokenUtil.CLAIM_KEY_USER_ID);
                if (jwtTokenUtil.isTokenExpired(authToken)) {
                    throw new ServiceException(ResponseCode.USER_ERROR_RELOGIN_CODE.getCode(), ResponseCode.USER_ERROR_RELOGIN_CODE.getMessage());
                }

                UserInfoRequest userRequest =new UserInfoRequest();
                userRequest.setUserId(Long.valueOf(userId));
                UserInfoResponse userInfo=userInfoService.selectUserInfoByUserId(userRequest);
                if (userInfo == null) {
                    throw new ServiceException(ResponseCode.USER_LOGIN_CODE3.getCode(), ResponseCode.USER_LOGIN_CODE3.getMessage());
                }
                ThreadLocalHelp.setCurrentUserId(Long.valueOf(userId));
                ThreadLocalHelp.setCurrentAuthToken(authToken);
                ThreadLocalHelp.setCurrentUserName(userName);
            } else {
                throw new ServiceException(ResponseCode.USER_ERROR_RELOGIN_CODE.getCode(), ResponseCode.USER_ERROR_RELOGIN_CODE.getMessage());
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        ThreadLocalHelp.remove();

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 9;
    }


    private String loginCheck(Object handler, String requestURI) {
         // 不是方法直接跳过
        if (!(handler instanceof HandlerMethod)) {
            return null;
        }
        // 这个方法一般就是controller
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取注解在对象上的注解中的FeignClient, FeignClient不鉴权
        Class feignClientClass = Arrays.stream(handlerMethod.getBeanType().getInterfaces()).filter(i -> {
            FeignClient feignClient = AnnotationUtils.findAnnotation(i, FeignClient.class);
            if (Objects.nonNull(feignClient)) {
                return true;
            }
            return false;
        }).findAny().orElse(null);
        if (feignClientClass != null) {
            return null;
        }


        return "1";
//        if (!StringUtils.isBlank(customProperties.getApplicationWhitelist()) && StringUtils.indexOf(customProperties.getApplicationWhitelist(), requestURI) != -1) {
//            return null;
//        } else {
//            log.info("请求地址:{}, 需要进行后台鉴权", requestURI);
//            return "1";
//        }
    }
}
