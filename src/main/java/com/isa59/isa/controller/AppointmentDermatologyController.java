package com.isa59.isa.controller;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isa59.isa.model.AppointmentDermatology;
import com.isa59.isa.service.AppointmentDermatologyService;

@RestController
@RequestMapping(value = "/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentDermatologyController {

	@Autowired
	private AppointmentDermatologyService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<AppointmentDermatology>> getAppointments() {
		
		List<AppointmentDermatology> appointments=service.getAll();
		//System.out.println("inAll:" + appointments);
		return new ResponseEntity<>(appointments,HttpStatus.OK);
	}
	
	@GetMapping("/free")
	public ResponseEntity<List<AppointmentDermatology>> getFreeAppointments() {

		List<AppointmentDermatology> appointments=service.getAllFree();
		return new ResponseEntity<>(appointments,HttpStatus.OK);
	}
	
	@PostMapping("/new")
	public ResponseEntity<AppointmentDermatology> newAppointment(@RequestBody AppointmentDermatology appointment) {

		service.add(appointment);
		return new ResponseEntity<>(appointment, HttpStatus.CREATED);
	}
	
	@PostMapping("/reserve/{appointmentID}")
	public ResponseEntity<AppointmentDermatology> reserveAppointment(@RequestBody String patientID, @PathVariable long appointmentID) {
		
		AppointmentDermatology appointment=service.reserve(appointmentID, patientID);
		System.out.println("inReserveController" + appointment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/cancel/{patientID}")
	public ResponseEntity<AppointmentDermatology> cancelAppointment(@RequestBody long appointmentID, @PathVariable String patientID) {

		AppointmentDermatology appointment=service.cancel(appointmentID, patientID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
