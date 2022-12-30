package com.phoenix.sca.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@ComponentScan(value = {"com.phoenix.sca.common","com.phoenix.sca.service", "com.phoenix.sca.integration", "com.phoenix.sca.mapper"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableAutoConfiguration()
@Configuration()
public class Application {
}
