package com.arcmicroservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * @author Asus 04.11.2023
 */
@Configuration
public class UtilsConfig {

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}