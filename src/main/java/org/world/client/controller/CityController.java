package org.world.client.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.world.client.entity.City;
import org.world.config.RibbonConfiguration;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RibbonClient(name = "worldrs-v2", configuration = RibbonConfiguration.class)
public class CityController {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="citysReliable")
	@RequestMapping(value="/city", method = RequestMethod.GET, produces="application/json")
	public City[] getAll() throws URISyntaxException {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/city",City[].class);	
	}
	
	@HystrixCommand(fallbackMethod="cityReliable")
	@RequestMapping(value="/city/{cityID}", method = RequestMethod.GET,  produces="application/json")
	public City getByID(@PathVariable Integer cityID) {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/city/"+cityID ,City.class);
	}
	@HystrixCommand(fallbackMethod="cityReliable")
	@RequestMapping(value="/city/name/{name}", method = RequestMethod.GET,  produces="application/json")
	public City getByName(@PathVariable String name) {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/city/name/"+ name ,City.class);
	}
	@HystrixCommand(fallbackMethod="citysReliable")
	@RequestMapping(value="/city/country/code/{countryCode}", method = RequestMethod.GET,  produces="application/json")
	public City[] getByCountyCode(@PathVariable String countryCode) {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/city/country/code/" +   countryCode ,City[].class);
	}
	
	public City  cityReliable(Integer cityID) {
		City city = new City();
		city.setId(1027);
		city.setName("Chennai (Madras)");
		city.setCountryCode("IND");
		city.setDistrict("Tamil Nadu");
		city.setPopulation("3841396");
		return city;
	}
	
	
	public City  cityReliable(String name) {
		City city = new City();
		city.setId(1027);
		city.setName("Chennai (Madras)");
		city.setCountryCode("IND");
		city.setDistrict("Tamil Nadu");
		city.setPopulation("3841396");
		return city;
	}
	
	
	public City[]  citysReliable() {
 
		City city = new City();
		city.setId(1027); 
		city.setName("Chennai (Madras)");
		city.setCountryCode("IND");
		city.setDistrict("Tamil Nadu");
		city.setPopulation("3841396");
		
		City city1 = new City();
		city1.setId(1173);
		city1.setName("Vellore");
		city1.setCountryCode("IND");
		city1.setDistrict("Tamil Nadu");
		city1.setPopulation("175061");
		
		
		City city2 = new City();
		city2.setId(1028);
		city2.setName("Hyderabad");
		city2.setCountryCode("IND");
		city2.setDistrict("Andhra Pradesh");
		city2.setPopulation("2964638");
		City[] citys = {city, city1, city2};
		return citys;
	}
	
	public City[]  citysReliable(String code) {
		 
		City city = new City();
		city.setId(1027); 
		city.setName("Chennai (Madras)");
		city.setCountryCode("IND");
		city.setDistrict("Tamil Nadu");
		city.setPopulation("3841396");
		
		City city1 = new City();
		city1.setId(1173);
		city1.setName("Vellore");
		city1.setCountryCode("IND");
		city1.setDistrict("Tamil Nadu");
		city1.setPopulation("175061");
		
		
		City city2 = new City();
		city2.setId(1028);
		city2.setName("Hyderabad");
		city2.setCountryCode("IND");
		city2.setDistrict("Andhra Pradesh");
		city2.setPopulation("2964638");
		City[] citys = {city, city1, city2};
		return citys;
	}
}
