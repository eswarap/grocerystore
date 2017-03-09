package com.woven.grocerystore.config;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@PropertySource("classpath:liquibase.properties")
public class LiquibaseConfig {
    
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource()  {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println("driver = "+env.getProperty("driver"));
        dataSource.setDriverClassName(env.getProperty("driver"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));

        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase()  {
        SpringLiquibase liquibase = new SpringLiquibase();

        liquibase.setDataSource(dataSource());
//        liquibase.setChangeLog("classpath:db-changelog-master.xml");

        return liquibase;
    }
}
