package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.PaymentModel;
import com.example.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	public  List<PaymentModel> findAllPayments(int userId)
	{
		return paymentRepository.findAll();
	}
	
	public void savePayment(PaymentModel model) {
		paymentRepository.save(model);
	}

	public PaymentModel findRecentPayments(int userId) {
		return paymentRepository.findByUserId(userId).get(0);
	}

}
