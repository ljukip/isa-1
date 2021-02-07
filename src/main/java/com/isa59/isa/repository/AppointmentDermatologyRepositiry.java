package com.isa59.isa.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isa59.isa.model.AppointmentDermatology;


public interface AppointmentDermatologyRepositiry extends JpaRepository<AppointmentDermatology, Long> {
	
	List<AppointmentDermatology> findAll();

}
