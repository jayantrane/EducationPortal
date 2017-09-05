package com.spring.web.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
@Component("reviewdao")
public class ReviewDao {
	private NamedParameterJdbcTemplate jdbc;
	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Review> getReviews(){
		return jdbc.query("select * from review", new RowMapper<Review>(){
			@Override
			public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Review review = new Review();
				review.setName(rs.getString("name"));
				review.setEmail(rs.getString("email"));
				review.setCollege(rs.getString("college"));
				review.setFeedback(rs.getString("feedback"));
				return review;
			}
			
			
		});
	}
	public boolean create(Review review){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(review);
	
		return jdbc.update("insert into review(name,email,college,feedback) values(:name,:email,:college,:feedback)",param) ==1;
	}
}
 