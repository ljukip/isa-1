package com.isa59.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa59.isa.dto.PharmacyDTO;
import com.isa59.isa.model.Pharmacy;
import com.isa59.isa.service.PharmacyService;

@RestController
@RequestMapping(value = "/pharmacy", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyController {
	
	@Autowired
	PharmacyService pharmacyService;
	
	@GetMapping("/searchName/{name}")
	ResponseEntity<List<PharmacyDTO>> searchPharmaciesByName(@PathVariable String name)
	{
		List<Pharmacy> pharmacies = pharmacyService.findAll();
		List<PharmacyDTO> pharmacyDTO = new ArrayList<PharmacyDTO>();
		
		for(Pharmacy ph : pharmacies) {
			if(ph.getName().equals(name)) {
				System.out.println("Tu sammmm");
				PharmacyDTO pf = new PharmacyDTO();
				pf.setId(ph.getId());
				pf.setAddress(ph.getAddress());
				pf.setCity(ph.getCity());
				pf.setCountry(ph.getCountry());
				pf.setMark(ph.getMark());
				
				pharmacyDTO.add(pf);
				
			}
		}
		
		return pharmacyDTO == null ? 
				new ResponseEntity<>(HttpStatus.NOT_FOUND) :
					ResponseEntity.ok(pharmacyDTO);
		
	}
	

}
