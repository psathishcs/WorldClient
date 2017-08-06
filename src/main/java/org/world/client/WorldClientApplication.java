package org.world.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class WorldClientApplication {
	public static void main(String[] args){
		SpringApplication.run(WorldClientApplication.class, args);
	}
}
