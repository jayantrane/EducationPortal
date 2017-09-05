package com.spring.web.data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.*;

public class User {
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", enabled=" + enabled
				+ ", authority=" + authority + "]";
	}
	@NotBlank(message="Username must not be blank")
	@Size(min=5 , max=12 , message="Username must have 5 to 12 characters")
	public String username;
	
	@Size(min=5 , max=12 ,message="Password much contain 5 to 12 characters ")
	public String password;
	
	@Pattern(regexp="\\b\\w+\\@\\w+\\.\\w+\\b" , message="Enter valid email address")
	public String email;
	public boolean enabled ;
	public String authority;
	
	public User(){

	}
	
	
	
	public User(
			 String username,
			 String password,
			String email, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
}
