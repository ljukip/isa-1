package com.isa59.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa59.isa.model.Dermatologist;

public interface DermatologistRepository extends JpaRepository<Dermatologist, Long> {
	
}
