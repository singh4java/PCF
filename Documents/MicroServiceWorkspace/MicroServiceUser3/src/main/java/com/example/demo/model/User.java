package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String ssn;
	private String fistrName;
	private String lastName;
	private String courseCode;
	
	public User() {
		
	}
	public User(String ssn, String fistrName, String lastName, String courseCode) {
	
		this.ssn = ssn;
		this.fistrName = fistrName;
		this.lastName = lastName;
		this.courseCode = courseCode;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFistrName() {
		return fistrName;
	}
	public void setFistrName(String fistrName) {
		this.fistrName = fistrName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	@Override
	public String toString() {
		return "User [ssn=" + ssn + ", fistrName=" + fistrName + ", lastName=" + lastName + ", courseCode=" + courseCode
				+ "]";
	}
	
	

}
