package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This is creating auto generated unique identifier
	private int userId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String address;
	@Column
	private String phoneNumber;
	@Column
	private String email;
	@Column
	private String role;
	@Column
	private String password;
	
	
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", role=" + role + ", password="
				+ password + "]";
	}

	
}
