package com.isa59.isa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false , unique = true)
	private String name;
	
	
	private String description;
	
	@Column(nullable = false)
	private String address;
	
	@OneToMany
	private List<Pharmacist> pharmacists;
	
	@ManyToMany
	private List<Dermatologist> dermatologists;
	
	@OneToMany
	private List<MedicationData> medicationDatas;
	
	@OneToMany
	private List<PharmacyAdmin> phAdmins;
	
	//private float averageRating;
	
	
	public Pharmacy() {}


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


	public List<Pharmacist> getPharmacists() {
		return pharmacists;
	}


	public void setPharmacists(List<Pharmacist> pharmacists) {
		this.pharmacists = pharmacists;
	}


	public List<Dermatologist> getDermatologists() {
		return dermatologists;
	}


	public void setDermatologists(List<Dermatologist> dermatologists) {
		this.dermatologists = dermatologists;
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


	public List<PharmacyAdmin> getPhAdmins() {
		return phAdmins;
	}


	public void setPhAdmins(List<PharmacyAdmin> phAdmins) {
		this.phAdmins = phAdmins;
	}
	

}
