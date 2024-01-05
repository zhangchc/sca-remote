package com.phoenix.sca.remote;

import com.phoenix.sca.service.Application;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


@Slf4j
@Import(Application.class)
@SpringBootApplication
@MapperScan(basePackages = {"com.phoenix.sca.mapper"})
@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationRemoteStart {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext= SpringApplication.run(ApplicationRemoteStart.class, args);
        log.info("===============================");
        log.info("===sca-remote start success!===");
        log.info("===============================");
    }

}