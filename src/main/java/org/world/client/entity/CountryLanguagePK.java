package org.world.client.entity;

import java.io.Serializable;


public class CountryLanguagePK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String countryCode;
	private String language;
	
	public CountryLanguagePK() {}
	
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
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("CountryCode = ").append(countryCode).append(", ")
				.append("Language = ").append(language).append(", ");
		return str.toString();
	}

}
