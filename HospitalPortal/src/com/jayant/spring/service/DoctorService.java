package com.jayant.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayant.spring.data.Doctor;
import com.jayant.spring.data.DoctorDao;

@Service("doctorservice")
public class DoctorService {
	@Autowired
	DoctorDao doctorDao ;
	
	public boolean createDoctor(Doctor doctor){
		return doctorDao.createDoctor(doctor);
		
	}
	
	public List<String> getDoctorNames(){
		return doctorDao.getDoctorNames();
	}
	public int getDoctorIdFromName(String name){
		return doctorDao.getDoctorIdFromName(name);
	}

	public int getDoctorIdFromUsername(String name) {
		System.out.println("service == doctor== username");
		return doctorDao.getDoctorIdFromUsername(name);
	}

	public boolean checkIfDoctor(String username) {
		System.out.println("service == doctor== checkusername");
		return doctorDao.checkIfDoctor(username);
		
	}
}
