package com.isa59.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa59.isa.model.Rating;

public interface RatingRepositiry  extends JpaRepository<Rating, Long>{

}
