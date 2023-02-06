package com.theceshop.springboot.web.app;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfig {
	
	@Bean
    DataSource getDataSource() {
        return (DataSource) DataSourceBuilder.create()
          .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
          .url("jdbc:sqlserver://localhost:1433;databaseName=master;encrypt=true;trustServerCertificate=true")
          .username("sa")
          .password("yourStrong(!)Password")
          .build();	
    }

}
