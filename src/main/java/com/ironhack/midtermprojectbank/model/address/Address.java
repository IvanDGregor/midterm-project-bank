package com.ironhack.midtermprojectbank.model.address;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String street, String number, String zipCode, String city, String country) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
