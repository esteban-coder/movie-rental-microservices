package com.imagenes.fotos_mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FotosMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FotosMongoApplication.class, args);
	}

}
