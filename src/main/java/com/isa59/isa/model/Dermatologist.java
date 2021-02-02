package com.isa59.isa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Dermatologist extends User{
	
	@ManyToMany
	private List<Pharmacy> pharmacies;

}
