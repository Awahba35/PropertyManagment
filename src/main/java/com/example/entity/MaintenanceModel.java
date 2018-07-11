package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MaintenanceModel {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) //This is creating auto generated unique identifier
private int maintId;

@Column
private String maintOptions;

@Column
private String message;

@Column
private String email;


public int getMaintId() {
	return maintId;
}

public void setMaintId(int maintId) {
	this.maintId = maintId;
}

public String getMaintOptions() {
	return maintOptions;
}

public void setMaintOptions(String maintOptions) {
	this.maintOptions = maintOptions;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
