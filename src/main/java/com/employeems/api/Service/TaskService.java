package com.employeems.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeems.api.Data.TaskRepo;
import com.employeems.api.model.Task;

@Service
public class TaskService 
{
	 @Autowired
	    private TaskRepo taskRepo;
	    public void addTask(Task task) 
	    {
	        taskRepo.save(task);
	    }
	    public  List<Task> getAllTasks() 
	    {	        
	    	return taskRepo.findAll();
	    }
	    public Optional<Task> getById(int task_id) 
		{
			Optional<Task> optional=taskRepo.findById(task_id);
			if(optional==null)
				return null;
			return optional;
		}
	    public void deleteTaskById(int task_id) 
		{			
			taskRepo.deleteById(task_id);			
		}
	    
	    public void postTask(Task task) {
			// save employee in DB 
			taskRepo.save(task);
			
		}
	    
	    public Optional<Task> getTaskById(int task_id) {
			 
			return taskRepo.findById(task_id);
		}

	
}
