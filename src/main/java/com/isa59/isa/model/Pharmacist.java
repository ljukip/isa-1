package com.isa59.isa.model;

import java.security.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pharmacist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true )
	private Timestamp workingDateFrom;
	
	@Column(nullable = true )
	private Timestamp workingDateTo;
	
	@Column(nullable = false )
	private long pharmacyID;
	
	@OneToMany
	private List<Consultation> consultations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getWorkingDateFrom() {
		return workingDateFrom;
	}

	public void setWorkingDateFrom(Timestamp workingDateFrom) {
		this.workingDateFrom = workingDateFrom;
	}

	public Timestamp getWorkingDateTo() {
		return workingDateTo;
	}

	public void setWorkingDateTo(Timestamp workingDateTo) {
		this.workingDateTo = workingDateTo;
	}

	public long getPharmacyID() {
		return pharmacyID;
	}

	public void setPharmacyID(long pharmacyID) {
		this.pharmacyID = pharmacyID;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Pharmacist() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
