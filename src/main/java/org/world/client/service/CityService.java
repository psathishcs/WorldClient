package org.world.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityService {
	@Autowired
	RestTemplate worldServiceRestTemplate;
	
	public final String uri = "http://world-rs-v1/";
	
	public String getAll(){
		String url = uri + "/v1/world/api/city";
		return worldServiceRestTemplate.getForObject(url, String.class);
		
	}
}
