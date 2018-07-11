package com.example.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.MaintenanceModel;
import com.example.entity.PaymentModel;
import com.example.entity.UserModel;

@Service
public class EmailService {
	@Autowired
	private MaintenanceService maitenanceService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private SendMail sendMail;

	public void sendRentReminder(UserModel user) {
		PaymentModel pay = paymentService.findRecentPayments(user.getUserId());
		LocalDate date = LocalDate.now(ZoneId.systemDefault());
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date2 = LocalDate.parse(pay.getDueDate(), fmt);
		
		long diff =  date.until(date2,ChronoUnit.DAYS);
		String msg ="";
		String subject="";
		if(diff <= 5 && diff > 0)
		{
			subject ="Rent Reminder";
			msg = "Hello " +user.getFirstName()+",\n\n This is a frindley remider that your rent is due on "
						+pay.getDueDate() + "\n\n Thank You,\nManagement";
			
		}
		else if(diff < 0)
		{
			subject="Late Rent Reminder";
			msg = "Hello, " +user.getFirstName() +" \n\n This is notification that you have not payed rent that was due on "
					+pay.getDueDate()+ "You have been charged a late fee of $50 dollars and will acrew a $5 dollar "
					+ "fee everyday until the account is payed in full. Please contact us with any questions you "
					+"have regarding this email. "
					+"\n\n Thank You,\nManagement";
		}
		
		sendMail.sendMail(user.getEmail(), subject, msg);
		
	}
	
	public void maitenanceEmail (MaintenanceModel maint){
		
		maitenanceService.sendMaintenanceRequest(maint);
		String subject = "";
		
		if(maint.getMaintOptions().equals("General Maitenance")) {
			subject ="General Maitenance";
		}
		else if(maint.getMaintOptions().equals("Electrical"))
		{
			subject ="Electrical";
		}
		else if(maint.getMaintOptions().equals("HVAC"))
		{
			subject ="HVAC";
		}
		else if(maint.getMaintOptions().equals("Plumbing"))
		{
			subject ="Plumbing";
		}
		
		sendMail.sendMail("ahmedwahba638@gmail.com", subject, maint.getMessage());
		
	}
}