package com.jayant.spring.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("reportdao")
public class ReportDao {
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public boolean createreport(Report report){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(report);
		return jdbc.update("insert into reports(time,prescription,remark,patient_id) values(:time,:prescription,:remark,:patient_id)"	, param)==1;
		
	}

	public List<Report> getReportByPatientId(int patientid) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", patientid);
		return jdbc.query("select * from reports where patient_id=:id",param, new RowMapper<Report>(){
			
			@Override
			public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
				Report report = new Report();
				report.setTime(rs.getString("time"));
				report.setPrescription(rs.getString("prescription"));
				report.setRemark(rs.getString("remark"));
				return report;
			}
			
		});
	}
}
