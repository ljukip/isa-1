package com.isa59.isa.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa59.isa.dto.BuyingDTO;
import com.isa59.isa.service.BuyingService;

@RestController
@RequestMapping(value = "/buying", produces = MediaType.APPLICATION_JSON_VALUE)
public class BuyingContoller {
	
	@Autowired
	private BuyingService buyingService;
	
	@PreAuthorize("hasRole('ROLE_PHADMIN')")
	@PostMapping("/")
	public ResponseEntity<BuyingDTO> create(Principal principal, @RequestBody BuyingDTO buyingDTO){
		BuyingDTO ret = buyingService.create(principal.getName(),buyingDTO);
		return new ResponseEntity<>(ret, HttpStatus.CREATED);
	}

}
