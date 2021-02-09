package com.isa59.isa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pharmacies")
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false , unique = true)
	private String name;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String country;
	@Column(nullable = true)
	private double mark;
	
	@Column(nullable = true)
	private Long rating;
	
	@Column(nullable = true)
	private Long consultationPrice;
	
	
	@OneToMany
	private List<User> pharmacists;
	
	@ManyToMany
	private List<User> dermatologists;
	
	@OneToMany
	private List<MedicationData> medicationDatas;
	
	@OneToMany
	private List<User> phAdmins;
	
	//private float averageRating;
	
	
	public Pharmacy() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	

	public List<MedicationData> getMedicationDatas() {
		return medicationDatas;
	}


	public void setMedicationDatas(List<MedicationData> medicationDatas) {
		this.medicationDatas = medicationDatas;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<User> getPharmacists() {
		return pharmacists;
	}


	public void setPharmacists(List<User> pharmacists) {
		this.pharmacists = pharmacists;
	}


	public List<User> getDermatologists() {
		return dermatologists;
	}


	public void setDermatologists(List<User> dermatologists) {
		this.dermatologists = dermatologists;
	}


	public List<User> getPhAdmins() {
		return phAdmins;
	}


	public void setPhAdmins(List<User> phAdmins) {
		this.phAdmins = phAdmins;
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


	public double getMark() {
		return mark;
	}


	public void setMark(double mark) {
		this.mark = mark;
	}

}
