package com.noris.prueba.bci.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DataSourceJpa {

    /*@Value("${spring.datasource.driverClassName}")
    private String driverName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource datasource() throws PropertyVetoException {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }*/
}