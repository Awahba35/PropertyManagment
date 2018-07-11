package com.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.PaymentModel;

@Repository

public interface PaymentRepository extends JpaRepository<PaymentModel, Integer>{

	//@Query("Select P from PaymentModel P where userId=:userId order by paymentId desc")
	List<PaymentModel> findByUserId(int userId);
	
	

}
