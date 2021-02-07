package com.isa59.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isa59.isa.model.AppointmentDermatology;
import com.isa59.isa.repository.AppointmentDermatologyRepositiry;

@Service
public class AppointmentDermatologyService {
	
	@Autowired
	private AppointmentDermatologyRepositiry repository;
	
	public List<AppointmentDermatology> getAll(){
		List<AppointmentDermatology> appointments= new ArrayList<>();
		repository.findAll().forEach(appointments::add);
		System.out.println("inGetAllService" +  appointments);
		return appointments;
	}
	
	public List<AppointmentDermatology> getAllFree(){
		List<AppointmentDermatology> allAppointments= repository.findAll();
		System.out.println("inGetFreeService" +  allAppointments);
		List<AppointmentDermatology> freeAppointments= new ArrayList<>();
		for(AppointmentDermatology a : allAppointments) {

			System.out.println("inGetFreeService" +  a.getPatientID());
			if(a.getPatientID().equals("") || a.getPatientID().equals(null)) {
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
		repository.saveAndFlush(appointment);
	}
	
	public AppointmentDermatology reserve(long appointmentID, String patientID) {
		AppointmentDermatology appointment=repository.getOne(appointmentID);
		appointment.setPatientID(patientID);
		System.out.println("inreserve:" + appointment);
		repository.saveAndFlush(appointment);
		return appointment;
	}
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public AppointmentDermatology cancel(long appointmentID, String patientID) {
		AppointmentDermatology appointment=repository.findById(appointmentID).get();
		appointment.setPatientID(null);
		repository.saveAndFlush(appointment);
		return appointment;
	}

}
