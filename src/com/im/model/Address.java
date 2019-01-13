package com.im.model;

import javax.persistence.Embeddable;

@Embeddable // embaddable for each embedded entity / this one created created table / send this Address variables to each embedded Classes
public class Address {

	String street;
	String city;
	String country;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
