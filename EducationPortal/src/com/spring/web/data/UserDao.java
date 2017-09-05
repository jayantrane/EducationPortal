package com.spring.web.data;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("userdao")
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;
	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public boolean create(User user){
		System.out.println("from service to dao");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		System.out.println("Tables to be updated");
		jdbc.update("insert into users(username,email,password,enabled) values(:username,:email,:password,:enabled)",param);
		System.out.println("One table updated");
		return jdbc.update("insert into authorities(username,authority) values(:username,:authority)",param) ==1;
}
}
 