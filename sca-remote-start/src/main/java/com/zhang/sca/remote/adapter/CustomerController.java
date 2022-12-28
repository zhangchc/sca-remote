package com.zhang.sca.remote.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class CustomerController {

    @RequestMapping(value="/getUserInfo",method= RequestMethod.POST)
    public void getUserInfo(@RequestParam Long id) {
        log.info("======id=" + id);
    }
}
