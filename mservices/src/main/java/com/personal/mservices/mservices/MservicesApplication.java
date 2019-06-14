package com.personal.mservices.mservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@EnableEurekaServer
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class MservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MservicesApplication.class, args);
	}

}
 	