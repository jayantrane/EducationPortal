package com.jayant.spring.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


@Component("userdao")
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public boolean createUser(User user){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		jdbc.update("insert into authorities(username,authority) values(:username,:authority)",param) ;
		return jdbc.update("insert into users(username,password,age,type,name,enabled) values(:username,:password,:age,:type,:name,:enabled)", param)==1;
	}
	public List<User> getUsers(){
		return jdbc.query("select * from users", new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setType(rs.getString("type"));
				user.setName(rs.getString("name"));
				return user;
			}
		});
	}
	

}
