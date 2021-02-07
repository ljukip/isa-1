package com.isa59.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa59.isa.model.Buying;

public interface BuyingRepository extends JpaRepository<Buying, Long> {
	
}
