package com.zhang.sca.service.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author zhangchuancun
 * @date 2022/12/29 14:10
 */
@Configuration
public class MapperFacadeAutoWire {
    @Bean
    public MapperFacade mapperFacade() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
        return mapperFactory.getMapperFacade();
    }
}
