package com.employeems.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeems.api.Data.TaskProductOwnerRepo;
import com.employeems.api.model.TaskProductOwner;

@Service
public class TaskProductOwnerService {
	@Autowired
	private TaskProductOwnerRepo taskProductOwnerRepo;
	
	public void addTask(TaskProductOwner taskProductOwner) 
    {
        taskProductOwnerRepo.save(taskProductOwner);
    }
}