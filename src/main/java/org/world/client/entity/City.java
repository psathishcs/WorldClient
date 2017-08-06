package org.world.client.entity;

import java.io.Serializable;
public class City  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private String population;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("ID = ").append(id).append(", ")
							.append("Name = ").append(name).append(", ")
							.append("CountryCode = ").append(countryCode).append(", ")
							.append("District = ").append(district).append(", ")
							.append("population = ").append(population).append(".");
							
		return str.toString();
	}
}
