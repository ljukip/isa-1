package com.isa59.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa59.isa.model.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
	
}
