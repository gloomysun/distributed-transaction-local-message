package com.ly.user.config;

import com.ly.common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilsConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}
