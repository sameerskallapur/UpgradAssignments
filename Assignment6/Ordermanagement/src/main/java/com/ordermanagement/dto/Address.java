package com.ordermanagement.dto;

import javax.validation.constraints.NotNull;

public class Address {
	@NotNull
	private String city;
	@NotNull
	private String pincode;
	@NotNull
	private String country;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
