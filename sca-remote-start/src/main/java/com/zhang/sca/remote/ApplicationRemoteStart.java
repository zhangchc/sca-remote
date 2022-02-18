package com.zhang.sca.remote;

import com.zhang.sca.service.Application;
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
@MapperScan(basePackages = {"com.zhang.sca.mapper"})
@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationRemoteStart {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext= SpringApplication.run(ApplicationRemoteStart.class, args);
        String userName =applicationContext.getEnvironment().getProperty("user.name");
        String age =applicationContext.getEnvironment().getProperty("user.age");
        String address =applicationContext.getEnvironment().getProperty("user.address");
        System.out.println("======nocos config :"+userName+",age="+age+"address="+address);
        log.info("sca-remote start success!");
    }

}