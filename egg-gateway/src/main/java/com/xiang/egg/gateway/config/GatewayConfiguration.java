package com.xiang.egg.gateway.config;

import com.xiang.egg.gateway.filter.PasswordDecoderFilter;
import com.xiang.egg.gateway.filter.ValidateCodeGatewayFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiangCheng Xiang
 */
@Configuration
@EnableConfigurationProperties(GatewayConfigProperties.class)
public class GatewayConfiguration {

    @Bean
    public PasswordDecoderFilter passwordDecoderFilter(GatewayConfigProperties configProperties) {
        return new PasswordDecoderFilter(configProperties);
    }

    @Bean
    public ValidateCodeGatewayFilter validateCodeGatewayFilter() {
        return new ValidateCodeGatewayFilter();
    }

}
