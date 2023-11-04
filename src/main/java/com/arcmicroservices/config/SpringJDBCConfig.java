package com.arcmicroservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

/**
 * конфигурации для работы с базами различными типами
 *
 * @author nemykin 20.12.2020
 */
@Configuration
public class SpringJDBCConfig {

    @Bean
    @DependsOn("dataSource")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        var jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    @DependsOn("dataSource")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        var namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        return namedParameterJdbcTemplate;
    }

    /**
     * SimpleJdbcInsert для таблицы user
     *
     * @param dataSource
     * @return - экземпляр для SimpleJdbcInsert со связкой с таблицей user
     */
    @Bean
    @DependsOn("dataSource")
    public SimpleJdbcInsert userSimpleJdbcInsert(DataSource dataSource) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        simpleJdbcInsert.withTableName("user");
        return simpleJdbcInsert;
    }

    /**
     * SimpleJdbcInsert для таблицы game
     *
     * @param dataSource
     * @return - экземпляр для SimpleJdbcInsert со связкой с таблицей game
     */
    @Bean
    @DependsOn("dataSource")
    public SimpleJdbcInsert gameSimpleJdbcInsert(DataSource dataSource) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        simpleJdbcInsert.withTableName("game");
        return simpleJdbcInsert;
    }

    /**
     * SimpleJdbcInsert для таблицы character
     *
     * @param dataSource
     * @return - экземпляр для SimpleJdbcInsert со связкой с таблицей character
     */
    @Bean
    @DependsOn("dataSource")
    public SimpleJdbcInsert characterSimpleJdbcInsert(DataSource dataSource) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        simpleJdbcInsert.withTableName("character");
        return simpleJdbcInsert;
    }

}
