package com.packaginganddelevery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PackagingAndDeliveryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagingAndDeliveryMicroserviceApplication.class, args);
	}

}
