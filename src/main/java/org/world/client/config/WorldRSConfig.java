package org.world.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WorldRSConfig {
	
	@LoadBalanced
	@Bean
	public RestTemplate worldServiceRestTemplate(){
		return new RestTemplate();
	}
}
