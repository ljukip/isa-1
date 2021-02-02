package com.isa59.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa59.isa.model.Pharmacist;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
	
}
