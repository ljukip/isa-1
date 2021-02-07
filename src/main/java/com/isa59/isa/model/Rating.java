package com.isa59.isa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long stars;

	@Column(nullable = true)
	private long dermatologistID;
	
	@Column(nullable = true)
	private long pharmacyID;
	
	@Column(nullable = true)
	private long pharmacistID;
	
	@Column(nullable = true)
	private long medicationID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStars() {
		return stars;
	}

	public void setStars(Long stars) {
		this.stars = stars;
	}

	public long getDermatologistID() {
		return dermatologistID;
	}

	public void setDermatologistID(long dermatologistID) {
		this.dermatologistID = dermatologistID;
	}

	public long getPharmacyID() {
		return pharmacyID;
	}

	public void setPharmacyID(long pharmacyID) {
		this.pharmacyID = pharmacyID;
	}

	public long getPharmacistID() {
		return pharmacistID;
	}

	public void setPharmacistID(long pharmacistID) {
		this.pharmacistID = pharmacistID;
	}

	public long getMedicationID() {
		return medicationID;
	}

	public void setMedicationID(long medicationID) {
		this.medicationID = medicationID;
	}

	
	

}
