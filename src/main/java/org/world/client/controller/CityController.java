package org.world.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.world.client.service.CityService;

@RestController
public class CityController {
	@Autowired
	CityService cityService;
	
	@RequestMapping(value="/city", method = RequestMethod.GET, produces="application/json")
	public String getAll() {
		return cityService.getAll();
	}
}
