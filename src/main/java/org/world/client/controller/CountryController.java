package org.world.client.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.world.client.entity.Country;
import org.world.client.entity.CountryLanguage;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CountryController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="countrysReliable")
	@RequestMapping(value="/country", method = RequestMethod.GET,  produces="application/json")
	public Country[] getAll() {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/country",Country[].class);	
	}
	
	@HystrixCommand(fallbackMethod="countryReliable")
	@RequestMapping(value="/country/{code}", method = RequestMethod.GET,  produces="application/json")
	public Country getByID(@PathVariable String code) {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/country/" + code, Country.class);
	}
	
	@HystrixCommand(fallbackMethod="countryReliable")
	@RequestMapping(value="/country/name/{name}", method = RequestMethod.GET,  produces="application/json")
	public Country getByName(@PathVariable String name) {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/country/name/" + name, Country.class);
	}
	
	@HystrixCommand(fallbackMethod="countrysReliable")
	@RequestMapping(value="/country/continent/{continent}", method = RequestMethod.GET,  produces="application/json")
	public Country[] getByContinent(@PathVariable String continent) {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/country/continent/" + continent, Country[].class);
	}
	
	@HystrixCommand(fallbackMethod="countrysReliable")
	@RequestMapping(value="/country/region/{region}", method = RequestMethod.GET,  produces="application/json")
	public Country[] getByRegion(@PathVariable String region) {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/country/region/" + region, Country[].class);
	}
	
	@HystrixCommand(fallbackMethod="countrysReliable")
	@RequestMapping(value="/country/language/{language}", method = RequestMethod.GET,  produces="application/json")
	public List<Country> getByLanguage(@PathVariable String language) {
		CountryLanguage[] countryLanguages =  restTemplate.getForObject("http://worldrs-v2/v2/world/api/language/" + language, CountryLanguage[].class);
		List<Country> countrys = new ArrayList<>();
		
		Country country;
		for (CountryLanguage countryLanguage : countryLanguages){
			country = restTemplate.getForObject("http://worldrs-v2/v2/world/api/country/" + countryLanguage.getCountryLanguagePK().getCountryCode(), Country.class);
			countrys.add(country);
		}
		return countrys;
	}
	
	public Country countryReliable() {
		Country country = new Country();
		country.setName("India");
		return country;
	}
	public Country countryReliable(String region) {
		Country country = new Country();
		country.setName("India");
		return country;
		
	}
	public Country[] countrysReliable() {
		Country country1= new Country();
		Country country2= new Country();
		Country country3= new Country();
		country1.setName("India");
		country2.setName("United States");
		country3.setName("United Kingdom");
		Country[] countrys = {country1, country2, country3};
		return countrys;
	}
	public Country[] countrysReliable(String region) {
		Country country1= new Country();
		Country country2= new Country();
		Country country3= new Country();
		country1.setName("India");
		country2.setName("United States");
		country3.setName("United Kingdom");
		Country[] countrys = {country1, country2, country3};
		return countrys;
	}
}
