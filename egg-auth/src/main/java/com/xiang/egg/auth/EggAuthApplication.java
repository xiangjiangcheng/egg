package com.xiang.egg.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 认证授权中心
 *
 * @author Xiang JiangCheng
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EggAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(EggAuthApplication.class, args);
    }
}
