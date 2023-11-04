package com.arcmicroservices.config;

import com.arcmicroservices.dto.UserDto;
import com.arcmicroservices.model.User;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/**
 *
 */
@Slf4j
@Component
public class MapperConfig implements OrikaMapperFactoryConfigurer {


    @Bean
    DatatypeFactory datatypeFactory() throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance();
    }

    @Bean
    MappingContext.Factory mappingFactory() {
        var factory = new MappingContext.Factory();
        new DefaultMapperFactory.Builder().mappingContextFactory(factory).build();
        return factory;
    }

    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(User.class, UserDto.class)
                .field("username", "name")
                .fieldAToB("password", "password")
                .fieldAToB("password", "repeatPassword")
                .byDefault()
                .register();
    }
}