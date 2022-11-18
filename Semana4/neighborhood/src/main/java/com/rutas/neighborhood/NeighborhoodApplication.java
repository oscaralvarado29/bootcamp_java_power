package com.rutas.neighborhood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NeighborhoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeighborhoodApplication.class, args);
	}

}
