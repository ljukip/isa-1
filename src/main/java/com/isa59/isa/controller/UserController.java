package com.isa59.isa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa59.isa.service.UserService;
import com.isa59.isa.model.User;
import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/patients")
	public ResponseEntity<List<User>> getPatients() {
		List<User> patients = service.getPatients();
		return new ResponseEntity<>(patients, HttpStatus.OK); 
	}
}

