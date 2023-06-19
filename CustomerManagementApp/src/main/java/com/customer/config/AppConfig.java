package com.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.customer"})
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer{
	
	@Bean
	public InternalResourceViewResolver resolver() {
		
		InternalResourceViewResolver res = new InternalResourceViewResolver();
		res.setPrefix("/WEB-INF/jsp/");
		res.setSuffix(".jsp");	
		System.out.println(res);
		return res;
		
	}
}
