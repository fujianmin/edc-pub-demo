package com.newland.edc.pub.demo;

import com.newland.bd.ms.core.utils.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy = true)
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        SpringContextUtils.setApplicationContext(applicationContext);
    }
}
