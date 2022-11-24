package com.zhang.sca.remote.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {
    @Value("${user.name}")
    private  String userName;


    @RequestMapping("/test")
    public String add() {
        System.out.println("控制台打印。。。。。");
        log.info("////////////////"+userName);
        return "spring feign 调用" +userName;
    }



    @RequestMapping(value = "/canload")
    public Map<String, Object> canLoad(){
        Map<String, Object> res = new HashMap<>();
        res.put("state", "ok");
        res.put("msg", "you can load");
        return res;
    }
    // login模拟登录时token返回
    @RequestMapping(value = "/login")
    public String login(){
        return "111";
    }
}
