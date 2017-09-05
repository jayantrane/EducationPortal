package com.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.data.User;
import com.spring.web.data.UserDao;

@Service("userservice")
public class UserService {
	
	private UserDao userdao;
	@Autowired
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	public void create(User user){
		System.out.println("In service layer");
		userdao.create(user);
		
	}
	
}