package com.anand.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AnandServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnandServerApplication.class, args);
	System.out.println("Discovery server Start By Anand");
	}

}
