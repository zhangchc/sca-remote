package com.zhang.sca.remote.adapter;

import com.zhang.sca.facade.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {
    @Value("${user.name}")
    private  String userName;
@Resource
private TestService testService;

    @RequestMapping("/test")
    public String add() {
        System.out.println("控制台打印。。。。。");
        log.info("////////////////"+userName);
        testService.testQuery();
        return "spring feign 调用" +userName;
    }
}
