package com.arcmicroservice.microservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@SpringBootApplication
public class MicroserviceApplication {

    public static void main(String[] args) {
        var application = SpringApplication.run(MicroserviceApplication.class, args);
        BuildProperties buildProperties = application.getBean(BuildProperties.class);
        ConfigurableEnvironment env = application.getEnvironment();
        StringBuilder sb = new StringBuilder("\n----------------------------------------------------------\n\t");
        sb.append("Application: ").append(env.getProperty("spring.application.name")).append("\n\t");
        sb.append("Build version is ").append(buildProperties.getVersion()).append("\n\t");
        sb.append("Profile(s): ");
        sb.append(Arrays.stream(env.getActiveProfiles()).collect(Collectors.joining(", ")));
        sb.append(" \n").append("----------------------------------------------------------");
        log.info(sb.toString());
    }

}
