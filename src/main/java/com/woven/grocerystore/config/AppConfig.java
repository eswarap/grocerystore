package com.woven.grocerystore.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration
@ComponentScan({"com.woven.grocerystore.jpa"})
@ImportResource("classpath:src/main/resources/database-config.xml")
public class AppConfig {
    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("src/main/resources/initDB.sql").build();

    }


    @Bean(name = "h2Server", initMethod = "start", destroyMethod = "stop")
    @DependsOn(value = "h2WebServer")
    public Server createTcpServer() throws SQLException {
        return Server.createTcpServer("-tcp,-tcpAllowOthers,-tcpPort,9092".split(","));

    }


    @Bean(name = "h2WebServer", initMethod = "start", destroyMethod = "stop")
    public Server createWebServer() throws SQLException {
        return Server.createWebServer("-web,-webAllowOthers,-webPort,8082".split(","));

    }
}
