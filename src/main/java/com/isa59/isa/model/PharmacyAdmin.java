package com.isa59.isa.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PharmacyAdmin extends User{
	
	@ManyToOne
	private Pharmacy pharmacy;

}
