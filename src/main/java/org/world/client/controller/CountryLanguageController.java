package org.world.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.world.client.entity.CountryLanguage;
import org.world.client.entity.CountryLanguagePK;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class CountryLanguageController {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="languagesReliable")
	@RequestMapping(value="/language", method = RequestMethod.GET,  produces="application/json")
	public CountryLanguage[] getAll() {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/language",CountryLanguage[].class);
	}
	@HystrixCommand(fallbackMethod="languagesReliable")
	@RequestMapping(value="/language/country/{countryCode}", method = RequestMethod.GET,  produces="application/json")
	public CountryLanguage[] getByCountryCode(@PathVariable String countryCode) {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/language/country/ " + countryCode ,CountryLanguage[].class);
	}
	@HystrixCommand(fallbackMethod="languageReliable")
	@RequestMapping(value="/language/{language}", method = RequestMethod.GET,  produces="application/json")
	public CountryLanguage getByLanguage(@PathVariable String language) {
		return restTemplate.getForObject("http://worldrs-v2/v2/world/api/language/ " + language ,CountryLanguage.class);
	}
	
	public CountryLanguage[] languagesReliable(){
		CountryLanguage countryLanguage1 = new CountryLanguage();
		CountryLanguage countryLanguage2 = new CountryLanguage();
		CountryLanguage countryLanguage3 = new CountryLanguage();
		CountryLanguagePK countryLanguagePK = new CountryLanguagePK();
		countryLanguagePK.setLanguage("Tamil");
		countryLanguage1.setCountryLanguagePK(countryLanguagePK);
		countryLanguagePK = new CountryLanguagePK();
		countryLanguagePK.setLanguage("Telugu");
		countryLanguage2.setCountryLanguagePK(countryLanguagePK);
		countryLanguagePK = new CountryLanguagePK();
		countryLanguagePK.setLanguage("English");
		countryLanguage3.setCountryLanguagePK(countryLanguagePK);
		CountryLanguage[] countryLanguages = {countryLanguage1, countryLanguage2, countryLanguage3};
		return countryLanguages;
	}
	
	public CountryLanguage[] languagesReliable(String countryCode){
		CountryLanguage countryLanguage1 = new CountryLanguage();
		CountryLanguage countryLanguage2 = new CountryLanguage();
		CountryLanguage countryLanguage3 = new CountryLanguage();
		CountryLanguagePK countryLanguagePK = new CountryLanguagePK();
		countryLanguagePK.setLanguage("Tamil");
		countryLanguage1.setCountryLanguagePK(countryLanguagePK);
		countryLanguagePK = new CountryLanguagePK();
		countryLanguagePK.setLanguage("Telugu");
		countryLanguage2.setCountryLanguagePK(countryLanguagePK);
		countryLanguagePK = new CountryLanguagePK();
		countryLanguagePK.setLanguage("English");
		countryLanguage3.setCountryLanguagePK(countryLanguagePK);
		CountryLanguage[] countryLanguages = {countryLanguage1, countryLanguage2, countryLanguage3};
		return countryLanguages;
	}
	public CountryLanguage languageReliable(String language){
		CountryLanguage countryLanguage = new CountryLanguage();
		CountryLanguagePK countryLanguagePK = new CountryLanguagePK();
		countryLanguagePK.setLanguage("Tamil");
		countryLanguage.setCountryLanguagePK(countryLanguagePK);
		return countryLanguage;
	}
		
}
