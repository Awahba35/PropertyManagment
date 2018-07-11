package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  //creates table in sql
public class PaymentModel {

	@Column
	private int userId;
	
	@Column 
	private String firstName;
	
	@Column 
	private String lastName;
	
	@Column
	private double rentPayment;
	@Column
	private String dueDate;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //This is creating auto generated unique identifier
	private int paymentId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getRentPayment() {
		return rentPayment;
	}
	public void setRentPayment(double rentPayment) {
		this.rentPayment = rentPayment;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
}
