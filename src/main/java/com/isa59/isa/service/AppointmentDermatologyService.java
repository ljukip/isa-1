package com.isa59.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa59.isa.model.AppointmentDermatology;
import com.isa59.isa.repository.AppointmentDermatologyRepositiry;

@Service
public class AppointmentDermatologyService {
	
	@Autowired
	private AppointmentDermatologyRepositiry repository;
	
	public List<AppointmentDermatology> getAll(){
		List<AppointmentDermatology> appointments= new ArrayList<>();
		repository.findAll().forEach(appointments::add);
		return appointments;
	}
	
	public List<AppointmentDermatology> getAllFree(){
		List<AppointmentDermatology> allAppointments= repository.findAll();
		List<AppointmentDermatology> freeAppointments= new ArrayList<>();
		for(AppointmentDermatology a : allAppointments) {
			if(a.getPatientID()==null) {
				freeAppointments.add(a);
			}
		}
		return freeAppointments;
	}
	
	public List<AppointmentDermatology> getPatientsAppointments(String patientID){
		List<AppointmentDermatology> allAppointments= repository.findAll();
		List<AppointmentDermatology> appointments= new ArrayList<>();
		for(AppointmentDermatology a : allAppointments) {
			if(a.getPatientID()==patientID) {
				appointments.add(a);
				//future-passed check is done on the front
			}
		}
		return appointments;
	}
	
	//TODO: get dermatologist by id
	
	public void add(AppointmentDermatology appointment) {
		repository.save(appointment);
	}
	
	public AppointmentDermatology reserve(long appointmentID, String patientID) {
		AppointmentDermatology appointment=repository.getOne(appointmentID);
		appointment.setPatientID(patientID);
		repository.save(appointment);
		return appointment;
	}
	
	public AppointmentDermatology cancel(long appointmentID, String patientID) {
		AppointmentDermatology appointment=repository.getOne(appointmentID);
		appointment.setPatientID(null);
		repository.save(appointment);
		return appointment;
	}

}
