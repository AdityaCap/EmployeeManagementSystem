package com.employeems.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeems.api.Data.TaskManagerRepo;

import com.employeems.api.model.TaskManager;

@Service
public class TaskManagerService {
	
	@Autowired
	private TaskManagerRepo taskManagerRepo;
	
	public void insert(TaskManager taskManager) {
		taskManagerRepo.save(taskManager);
	}

}
