package org.world.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.world.config.RibbonConfiguration;

@RestController
@RibbonClient(name = "worldrs",configuration = RibbonConfiguration.class)
public class CityController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@RequestMapping(value="/city", method = RequestMethod.GET, produces="application/json")
	public String getAll() {
		return restTemplate.getForObject("http://worldrs/v2/world/api/city", String.class);
	}
	
	@RequestMapping(value="/cityLoad", method = RequestMethod.GET, produces="application/json")
	public String getAllLoad() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("worldrs");
		return restTemplate.getForObject("http://worldrs/v2/world/api/city", String.class);
	}
	
}
