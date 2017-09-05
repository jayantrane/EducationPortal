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

@Component("doctorpatientdap")
public class DoctorPatientDao {
	NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean createDoctorPatient(DoctorPatient doctorPatient){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(doctorPatient);
		
		return jdbc.update("insert into doctorpatient(doctor_id,patient_id) values(:doctor_id,:patient_id)", param)==1;
	}

	public List<Integer> getPatientsId(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return jdbc.query("select * from doctorpatient where doctor_id=:id", param,new RowMapper<Integer>(){

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("patient_id");
				return id;
			}
			
		});
		
	}
}
