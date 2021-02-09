package com.isa59.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa59.isa.model.Pharmacy;
import com.isa59.isa.model.User;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
	
//	public Pharmacy findOneByPhAdminsIn(List<User> users);
	List<Pharmacy> findAll();
//	Pharmacy findByName(String name);
}
