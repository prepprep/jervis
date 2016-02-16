package com.kai.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    @Size(max = 20)
    private String city;

    @Size(max = 20)
    private String county;

    @Size(max = 20)
    private String country;

    public String getAddressLine1() {
	return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
	return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
	return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
	this.addressLine3 = addressLine3;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getCounty() {
	return county;
    }

    public void setCounty(String county) {
	this.county = county;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

}
