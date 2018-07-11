package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //creates table in sql
public class EmailModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This is creating auto generated unique identifier
	private int emailTemplateId;
	@Column
	private String emailTemplateElementName;
	@Column
	private String emailContentText;
	
	
	
	public int getEmailTemplateId() {
		return emailTemplateId;
	}
	public void setEmailTemplateId(int emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}
	public String getEmailTemplateElementName() {
		return emailTemplateElementName;
	}
	public void setEmailTemplateElementName(String emailTemplateElementName) {
		this.emailTemplateElementName = emailTemplateElementName;
	}
	public String getEmailContentText() {
		return emailContentText;
	}
	public void setEmailContentText(String emailContentText) {
		this.emailContentText = emailContentText;
	}
}
