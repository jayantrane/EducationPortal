package com.jayant.spring.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("patientdao")
public class PatientDao {
	NamedParameterJdbcTemplate jdbc;
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public boolean createPatient(Patient patient){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(patient);
		return jdbc.update("insert into patients(username,password,name,age,doctor_id) values (:username,:password,:name,:age,:doctor_id)", param)==1;
	}
	
	public int getPatientIdFromName(String name){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", name);
		
		return jdbc.queryForObject("select id from patients where name=:name", param,Integer.class );
	}
	public int getPatientIdFromUsername(String username){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("username", username);
		
		return jdbc.queryForObject("select id from patients where username=:username", param,Integer.class );
	}

/*	public List<String> getPatientByIds(List<Integer> patientids) {
		List<String> names =new ArrayList<String>();
		
		for(int i=0 ; i<patientids.size();i++){
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("id", i);
			
			 names.add(e)jdbc.query("select * from patients where id=:id", param,new RowMapper<String>(){
				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException{
					
					return (rs.getString("username"));
					
				}
			});
		}
		return names;
	}*/

	public List<String> getPatientNames(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return jdbc.query("select * from patients where doctor_id=:id",param, new RowMapper<String>(){
			
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String name = rs.getString("name");
				return name;
			}
			
		});
	}
}
