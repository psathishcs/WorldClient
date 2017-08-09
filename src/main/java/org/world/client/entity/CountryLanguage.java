package org.world.client.entity;

import java.io.Serializable;

public class CountryLanguage implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private CountryLanguagePK countryLanguagePK;
	
	private char isOfficial;
	private float percentage;
		

	public CountryLanguagePK getCountryLanguagePK() {
		return countryLanguagePK;
	}

	public void setCountryLanguagePK(CountryLanguagePK countryLanguagePK) {
		this.countryLanguagePK = countryLanguagePK;
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
		StringBuilder str = new StringBuilder().append("CountryCode = ").append(countryLanguagePK.toString()).append(", ")
				.append("IsOfficial = ").append(isOfficial).append(", ")
				.append("Percentage = ").append(percentage).append(".");
				
		return str.toString();
	}
}
