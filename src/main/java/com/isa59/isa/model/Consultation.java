package com.isa59.isa.model;

import java.security.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Consultation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	private Timestamp date;
	
	@Column(nullable = false)
	private Long patientID;
	
	@Column(nullable = false)
	private Long pharmacistID;
	
}
