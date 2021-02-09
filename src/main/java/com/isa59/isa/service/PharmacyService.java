package com.isa59.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa59.isa.model.Pharmacy;
import com.isa59.isa.repository.PharmacyRepository;

@Service
public class PharmacyService  {
	
	 @Autowired
	private PharmacyRepository pharmacyRepository;


	public List<Pharmacy> findAll() {
	        return pharmacyRepository.findAll();
	    }
	 
	 public Pharmacy findByPharmacyName(String pharmacyName) {
		 return null;
	 }
	
	  public List<Pharmacy> getAllPharmacyNames() {
	        return null;
	    }
	

	

}
