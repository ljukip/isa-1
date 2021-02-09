package com.isa59.isa.dto;

public class PharmacyDTO {

	private Long id;
	private String pharmacyName;
	private String address;
	private String city;
	private String country;
	private Double mark;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Double getMark() {
		return mark;
	}
	public void setMark(Double string) {
		this.mark = string;
	}
	
	
}
