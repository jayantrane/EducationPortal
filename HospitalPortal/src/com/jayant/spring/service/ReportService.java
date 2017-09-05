package com.jayant.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayant.spring.data.Report;
import com.jayant.spring.data.ReportDao;

@Service("reportservice")
public class ReportService {
	private ReportDao reportDao;
	@Autowired
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	public boolean createreport(Report report){
		return reportDao.createreport(report);
	}
	public List<Report> getReportByPatientId(int patientid) {
		return reportDao.getReportByPatientId(patientid);
	}
	
}
