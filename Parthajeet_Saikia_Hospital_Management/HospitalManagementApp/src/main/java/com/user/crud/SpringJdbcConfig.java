package com.user.crud;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.user.crud")
public class SpringJdbcConfig {
	@Bean
	public static DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource  = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        
        return dataSource;
	}
}
