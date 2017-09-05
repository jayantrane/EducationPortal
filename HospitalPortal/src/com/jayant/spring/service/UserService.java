package com.jayant.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayant.spring.data.User;
import com.jayant.spring.data.UserDao;

@Service("userservice")
public class UserService {
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		System.out.println("==Userdao has been initialised==");
		this.userDao = userDao;
	}
	
	public boolean createUser(User user){
		return userDao.createUser(user);
	}
	
	public List<User> getCurrent(){
		System.out.println("===In user sevice==getCurrent==");
		return userDao.getUsers();
	}
	
	 
}
