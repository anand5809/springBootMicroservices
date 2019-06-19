package com.web.spring;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp1Application.class, args);
		System.out.println("App is running...");
	}
	
	/*
	 * @Bean public DataSource dataSource(DataSourceProperties dataSourceProperties)
	 * { return dataSourceProperties.initializeDataSourceBuilder().build(); }
	 */
}
