package com.customer.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.customer.service", "com.customer.dao" })
public class HibernateConfig {
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource ds) {
		System.out.println("Inside Hibernateconfig");

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.show_sql", true);
	    props.put("hibernate.hbm2ddl.auto", "update");

		//        // Setting C3P0 properties
		props.put("hibernate.c3p0.min_size","5");
		props.put("hibernate.c3p0.max_size","20");
		props.put("hibernate.c3p0.acquire_increment","1");
		props.put("hibernate.c3p0.timeout","1000");
		props.put("hibernate.c3p0.max_statements","150");

		factoryBean.setHibernateProperties(props);
		factoryBean.setPackagesToScan("com.customer.model");
		factoryBean.setDataSource(ds);

		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(LocalSessionFactoryBean factoryBean) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(factoryBean.getObject());
		return transactionManager;
	}

	@Bean
	public static DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}    

}
