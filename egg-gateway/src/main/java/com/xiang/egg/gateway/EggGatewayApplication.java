package com.xiang.egg.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Xiang JiangCheng
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EggGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EggGatewayApplication.class, args);
    }

}
