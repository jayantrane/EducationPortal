package com.jayant.spring.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("doctordao")
public class DoctorDao {
	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public boolean createDoctor(Doctor doctor){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(doctor);
		return jdbc.update("insert into doctors(username,password,name,age) values(:username,:password,:name,:age)", param)==1;
	}
	public List<String> getDoctorNames(){
		return jdbc.query("select * from doctors", new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String name = rs.getString("name");
				return name;
			}
			
		});
	}
	public int getDoctorIdFromName(String name){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", name);
		System.out.println("in dao fuck u bitch this is ghost" +name);
		
		return jdbc.queryForObject("select id from doctors where name=:name", param,Integer.class );
	}

	public int getDoctorIdFromUsername(String username) {
		System.out.println("dao==doctor==username");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("username", username);
		System.out.println("in dao " +username);
		int id = jdbc.queryForObject("select id from doctors where username=:username", param,Integer.class );
		System.out.println(id);
		return id;
	}

	public boolean checkIfDoctor(String username) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("username", username);
		System.out.println("in dao " +username);
		try{
		int id = jdbc.queryForObject("select id from doctors where username=:username", param,Integer.class );
		}catch(EmptyResultDataAccessException e){
			return false;
		}
		return true;
	}
}
