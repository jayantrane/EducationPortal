package com.jayant.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayant.spring.data.DoctorPatient;
import com.jayant.spring.data.DoctorPatientDao;

@Service("doctorpatientservice")
public class DoctorPatientService {
	@Autowired
	DoctorPatientDao doctorPatientDao ;
	@Autowired
	PatientService patientService;
	
	public boolean createDoctorPatient(DoctorPatient doctorPatient){
		return doctorPatientDao.createDoctorPatient(doctorPatient);
	}

	/*public List<String> getPatients(int id) {
		List<Integer> patientids = doctorPatientDao.getPatientsId(id);
		patientService.getPatientByIds(patientids);
		return null;
	}*/
}
