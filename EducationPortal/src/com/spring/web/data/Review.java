package com.spring.web.data;

import javax.validation.constraints.*;

public class Review {
	@NotNull
	@Size(min=5,max=80,message="Name must be of 5 and 80 letters")
	private String name;
	@NotNull
	@Pattern(regexp=".*\\@.*\\..*",message="Email should be correct")
	private String email;
	@NotNull
	@Size(min=5,max=80,message="College name must be of 5 and 80 letters")
	private String college;
	@NotNull
	private String feedback;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Review [name=" + name + ", email=" + email + ", college=" + college + ", feedback=" + feedback + "]";
	}
	

}
