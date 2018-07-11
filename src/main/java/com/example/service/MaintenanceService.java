package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.MaintenanceModel;
import com.example.repository.MaintenanceRepository;

@Service
public class MaintenanceService {
	
	@Autowired
	private MaintenanceRepository maintenanceRepository;
	
	
	public void sendMaintenanceRequest(MaintenanceModel maint) {
		maintenanceRepository.save(maint);
	}


}
