package com.web.spring.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
public class BeanConfig {
	@Bean
	public InternalResourceViewResolver setUpViewResolver() {
		InternalResourceViewResolver resolver=
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		//resolver.setViewNames(JstlView.class);
		return resolver;
		
	}
}
