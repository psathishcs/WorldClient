package org.world.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class RibbonConfig {
	@Bean
	public IRule ribbonRule(){
		return new RandomRule();
	}
	
	@Bean
	public IPing ribbonPing(IClientConfig config){
		return new PingUrl(); //we override default Iping which is a NoOpPing
	}
	@Bean
	public IRule ribbonRule(IClientConfig config){
		return new AvailabilityFilteringRule();
	}
}
