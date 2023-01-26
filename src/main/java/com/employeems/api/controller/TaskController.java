package com.employeems.api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employeems.api.Service.TaskService;
import com.employeems.api.model.Task;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/task/add")
	public ResponseEntity<String> addTask(@RequestBody Task task) {
		taskService.addTask(task);
		return ResponseEntity.status(HttpStatus.OK).body("Task Added");
	}

	@GetMapping("/task/getall")
	public List<Task> getAllEmployees() {
		List<Task> list = taskService.getAllTasks();
		return list;
	}

	@PostMapping("/task/one/{task_id}")
	public ResponseEntity<Object> getTaskById(@PathVariable("task_id") int task_id) {
		Optional<Task> optional = taskService.getById(task_id);
		if (!optional.isPresent()) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
		}
		Task task = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(task);
	}

	@DeleteMapping("/task/delete/{task_id}")
	public void deleteTask(@PathVariable("task_id") int task_id) {
		taskService.deleteTaskById(task_id);
		System.out.println("Employee Deleted Successfully");
	}

}
