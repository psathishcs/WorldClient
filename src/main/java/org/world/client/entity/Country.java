package org.world.client.entity;

import java.io.Serializable;

public class Country implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String name;
	private String continent;
	private String region;
	private String surfaceArea;
	private String indepYear;
	private Long population;
	private Float lifeExpectancy;
	private Double gnp;
	private Double gnpOld;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private Long capital;
	private String code2;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getContinent() {
		return continent;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(String surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(String indepYear) {
		this.indepYear = indepYear;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public Double getGnp() {
		return gnp;
	}

	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}

	public Double getGnpOld() {
		return gnpOld;
	}

	public void setGnpOld(Double gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Long getCapital() {
		return capital;
	}

	public void setCapital(Long capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("Code = ").append(code).append(", ")
				.append("Code = ").append(code).append(", ")
				.append("Name = ").append(name).append(", ")
				.append("Continent = ").append(continent).append(", ")
				.append("Region = ").append(region).append(", ")
				.append("SurfaceArea = ").append(surfaceArea).append(", ")
				.append("IndepYear = ").append(indepYear).append(", ")
				.append("Population = ").append(population).append(", ")
				.append("LifeExpectancy = ").append(lifeExpectancy).append(", ")
				.append("Gnp = ").append(gnp).append(", ")
				.append("GnpOld = ").append(gnpOld).append(", ")
				.append("LocalName = ").append(localName).append(", ")
				.append("GovernmentForm = ").append(governmentForm).append(", ")
				.append("HeadOfState = ").append(headOfState).append(", ")
				.append("Capital = ").append(capital).append(", ")
				.append("Code2 = ").append(code2).append(".");
		return str.toString();
	}
}
