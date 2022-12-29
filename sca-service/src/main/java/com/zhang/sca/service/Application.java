package com.zhang.sca.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@ComponentScan(value = {"com.zhang.sca.common","com.zhang.sca.service", "com.zhang.sca.integration", "com.zhang.sca.mapper"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableAutoConfiguration()
@Configuration()
public class Application {
}
