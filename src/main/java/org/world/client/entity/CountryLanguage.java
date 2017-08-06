package org.world.client.entity;

import java.io.Serializable;

public class CountryLanguage implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String countryCode;
	private String language;
	private char isOfficial;
	private float percentage;
		
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public char getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(char isOfficial) {
		this.isOfficial = isOfficial;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("CountryCode = ").append(countryCode).append(", ")
				.append("Language = ").append(language).append(", ")
				.append("IsOfficial = ").append(isOfficial).append(", ")
				.append("Percentage = ").append(percentage).append(".");
				
		return str.toString();
	}
}
