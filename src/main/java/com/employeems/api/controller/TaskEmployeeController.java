package com.employeems.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeems.api.Service.EmployeeService;
import com.employeems.api.Service.TaskEmployeeService;
import com.employeems.api.Service.TaskService;
import com.employeems.api.model.Employee;
import com.employeems.api.model.Task;
import com.employeems.api.model.TaskEmployee;

@RestController
@RequestMapping("/api/task/employee")
public class TaskEmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 
	@Autowired
	private TaskService taskService; 
	@Autowired
	private TaskEmployeeService taskEmployeeService;
	
	@PostMapping("/add/{task_id}/{emp_id}")
	public ResponseEntity<String> assignTaskToEmployee(
										@PathVariable("emp_id") int emp_id,
										@PathVariable("task_id") int task_id) {
		
		//instructorCourse object would have batch and year. 
		//we need to attach instructor and course to it.
		
		/* Fetch course Object from courseId */
		Optional<Employee> optionalC = employeeService.getById(emp_id);
		
		if(!optionalC.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Task ID Given");
		
		/* Fetch instructor object from instructorId */
		Optional<Task> optionalI = taskService.getTaskById(task_id);
		
		if(!optionalI.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Employee ID Given");
		
		Employee employee = optionalC.get();
		Task task = optionalI.get();
		
		TaskEmployee taskEmployee=new TaskEmployee();
		taskEmployee.setEmployee(employee);
		taskEmployee.setTask(task);
		
		taskEmployeeService.insert(taskEmployee);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task assigned to Employee");

		
	}
	
	

}
