package com.employeems.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeems.api.Service.ManagerService;
import com.employeems.api.Service.TaskManagerService;
import com.employeems.api.Service.TaskService;
import com.employeems.api.model.Employee;
import com.employeems.api.model.Manager;
import com.employeems.api.model.Task;
import com.employeems.api.model.TaskEmployee;
import com.employeems.api.model.TaskManager;

@RestController
@RequestMapping("/api/task/manager")
public class TaskManagerController {
	
	@Autowired
	private ManagerService managerService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private TaskManagerService taskManagerService;
	
	@PostMapping("/add/{task_id}/{m_id}")
	public ResponseEntity<String> assignTaskToManager(
										@PathVariable("m_id") int m_id,
										@PathVariable("task_id") int task_id) {
		
		//instructorCourse object would have batch and year. 
		//we need to attach instructor and course to it.
		
		/* Fetch course Object from courseId */
		Optional<Manager> optionalC = managerService.getManagerById(m_id);
		
		if(!optionalC.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Task ID Given");
		
		/* Fetch instructor object from instructorId */
		Optional<Task> optionalI = taskService.getTaskById(task_id);
		
		if(!optionalI.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Manager ID Given");
		
		Manager manager = optionalC.get();
		Task task = optionalI.get();
		
		TaskManager taskManager=new TaskManager();
		taskManager.setManager(manager);
		taskManager.setTask(task);
		
		taskManagerService.insert(taskManager);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Instructor assigned to Manager");

		
	}
	
	


}
