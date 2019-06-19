package com.web.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
public class SpringBootMvcDemoApplication extends SpringBootServletInitializer{
@Override
	protected SpringApplicationBuilder  configure(SpringApplicationBuilder app) {
		return app.sources(SpringBootMvcDemoApplication.class);
	}
		
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcDemoApplication.class, args);
		System.out.println("App is running...");
	}

}
