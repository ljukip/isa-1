package com.isa59.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa59.isa.model.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
	
}
