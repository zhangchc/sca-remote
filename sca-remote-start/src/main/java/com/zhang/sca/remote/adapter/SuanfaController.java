package com.zhang.sca.remote.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/suanfa")
public class SuanfaController {
    @RequestMapping("/test1")
    public void suanfa(){
        log.info("------------");
    }
}
