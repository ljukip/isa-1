package com.isa59.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isa59.isa.model.AppointmentDermatology;
import com.isa59.isa.model.User;
import com.isa59.isa.repository.AppointmentDermatologyRepositiry;
import com.isa59.isa.repository.UserRepository;

@Service
public class AppointmentDermatologyService {
	
	@Autowired
	private AppointmentDermatologyRepositiry repository;
	
	@Autowired
	private UserRepository userRepository;
	
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
			if(a.getPatientID()==null || a.getPatientID().equals("")) {
				freeAppointments.add(a);
			}
		}
		return freeAppointments;
	}
	
	public List<AppointmentDermatology> getPatientsAppointments(String patientID){
		List<AppointmentDermatology> allAppointments= repository.findAll();
		List<AppointmentDermatology> appointments= new ArrayList<>();
		for(AppointmentDermatology a : allAppointments) {
			System.out.println("poredi1: " + a.getPatientID() +" i "+ patientID);
			if(a.getPatientID()!=null && a.getPatientID().startsWith(patientID)) { //fix to work with full id
				appointments.add(a);
				//future-passed check is done on the front
			}
		}
		return appointments;
	}
	
	public User getDermatologist(String id){
		List<User> allUsers= userRepository.findAll();
		User dermatologist= new User();
		for(User a : allUsers) {
			System.out.println("porediDermatologist: " + a.getUsername() +" i "+ id);
			if(a.getRole().equals("DERMATOLOGIST") && a.getUsername().startsWith(id)) { //fix to work with full id
				dermatologist=a;
				//future-passed check is done on the front
			}
		}
		System.out.println("dermatologist: " + dermatologist);
		return dermatologist;
	}
	
	public void add(AppointmentDermatology appointment) {
		appointment.setDermatologist(getDermatologist(appointment.getDermatologistID()));
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
		System.out.println("inCancel" +  appointment);
		appointment.setPatientID(null);
		repository.saveAndFlush(appointment);
		return appointment;
	}

}
