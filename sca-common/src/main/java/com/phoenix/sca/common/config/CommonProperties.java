package com.phoenix.sca.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties("common")
public class CommonProperties {

    /**
     * jwt相关配置
     */
    private JwtConfig jwt;

    @Data
    public static class JwtConfig {
        private String tokenHeader;
        private String secret;
        private Long userExpiration;
    }

}
