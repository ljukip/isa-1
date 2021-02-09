package com.isa59.isa.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "appointmentDermatology")
public class AppointmentDermatology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String dermatologistID;
	
	@Column(nullable = true)
	private String patientID; //patientID = username

	@Column(nullable = false)
	private String times;

	@Column(nullable = true)
	private String duration;

	@Column(nullable = true)
	private Long price;

	@Column(nullable = false)
	private Timestamp dates;
	

	@Column(nullable = true)
	private User dermatologist;

	public AppointmentDermatology() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AppointmentDermatology(Long id, String dermatologistID, String patientID, String times, String duration,
			Long price, Timestamp dates, User dermatologist) {
		super();
		this.id = id;
		this.dermatologistID = dermatologistID;
		this.patientID = patientID;
		this.times = times;
		this.duration = duration;
		this.price = price;
		this.dates = dates;
		this.dermatologist = dermatologist;
	}



	public User getDermatologist() {
		return dermatologist;
	}



	public void setDermatologist(User dermatologist) {
		this.dermatologist = dermatologist;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDermatologistID() {
		return dermatologistID;
	}

	public void setDermatologistID(String dermatologistID) {
		this.dermatologistID = dermatologistID;
	}
	

	public String getTime() {
		return times;
	}

	public void setTime(String time) {
		this.times = time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Timestamp getDate() {
		return dates;
	}

	public void setDate(Timestamp date) {
		this.dates = date;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	
	

}
