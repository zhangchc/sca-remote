package com.phoenix.sca.remote.configuration;

import com.phoenix.sca.common.utils.JwtTokenUtil;
import com.phoenix.sca.remote.handler.AuthInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description
 * @Author hubin1
 * @Date 2022-10-19
 * @Version 1.0
 */
@Configuration
@EnableAutoConfiguration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 添加验证token的拦截器
         */
        registry.addInterceptor(getAuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login");
//        registry.addInterceptor(getCORSInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public AuthInterceptor getAuthInterceptor() {
        return new AuthInterceptor();
    }
    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }


}