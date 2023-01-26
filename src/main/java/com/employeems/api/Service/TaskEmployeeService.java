package com.employeems.api.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeems.api.Data.TaskEmployeeRepo;
import com.employeems.api.model.TaskEmployee;



@Service
public class TaskEmployeeService {

	@Autowired
	private TaskEmployeeRepo taskEmployeeRepo;
	
	public void insert(TaskEmployee taskEmployee) {
		taskEmployeeRepo.save(taskEmployee);
	}
	
	
}

