package com.arcmicroservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * UtilsConfig.
 *
 */
@Configuration
public class UtilsConfig {

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
