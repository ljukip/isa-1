package com.isa59.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa59.isa.model.MedicationData;

public interface MedicationDataRepository extends JpaRepository<MedicationData, Long> {
	
}
