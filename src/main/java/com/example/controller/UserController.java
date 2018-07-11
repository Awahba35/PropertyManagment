package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.MaintenanceModel;
import com.example.entity.PaymentModel;
import com.example.entity.UserModel;
import com.example.service.EmailService;
import com.example.service.PaymentService;
import com.example.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userModelService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private EmailService emailService;

	//Signing up new tenants to the app
	@RequestMapping(value="/register",produces= MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public ResponseEntity<HttpStatus> register(@RequestBody UserModel user){
		user.setRole("tenant");
		userModelService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	//Saves rent payments for each tenant
	@RequestMapping(value="/addPayment",produces= MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public ResponseEntity<HttpStatus> addPayment(@RequestBody PaymentModel paymentModel){
		paymentService.savePayment(paymentModel);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	//Depending on the user role (i.e.) an admin will have access to the entire app and will send email reminder email to pay rent as well as late notification email
	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity <UserModel> login(@RequestBody UserModel appUsers) {
		
		UserModel user = userModelService.login(appUsers.getEmail(),appUsers.getPassword());
		
			emailService.sendRentReminder(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
	}

	//Shows all the payments for each tenant when admin is using the app.
	@RequestMapping(value="/getPaymentDue", produces= MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public ResponseEntity<List<PaymentModel>> payments(int userId) {
		List<PaymentModel> payment = paymentService.findAllPayments(userId);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}

	//Sends the maintenance worker an email notifying him there is a request
	@RequestMapping(value="/maint",produces= MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public ResponseEntity<HttpStatus> maintainence(@RequestBody MaintenanceModel maintModel){
		emailService.maitenanceEmail(maintModel);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}