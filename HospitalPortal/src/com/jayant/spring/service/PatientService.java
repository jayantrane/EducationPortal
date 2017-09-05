package com.jayant.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayant.spring.data.Patient;
import com.jayant.spring.data.PatientDao;

@Service("patientservice")
public class PatientService {
	@Autowired
	PatientDao patientDao ;
	
	public boolean createPatient(Patient patient){
		return patientDao.createPatient(patient);
	}
	public int getPatientIdFromName(String name){
		int id=patientDao.getPatientIdFromName(name);
		System.out.println("in service"+id);
		return id;
	}
	public int getPatientIdFromUsername(String username){
		int id=patientDao.getPatientIdFromUsername(username);
		System.out.println("in service"+id);
		return id;
	}
	/*public void getPatientByIds(List<Integer> patientids) {
		return patientDao.getPatientByIds(patientids);
		
	}*/
	public List<String> getPatientNames(int id) {
		return patientDao.getPatientNames(id);
	}
	
}
