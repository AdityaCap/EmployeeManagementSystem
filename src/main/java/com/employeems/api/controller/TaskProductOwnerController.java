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

import com.employeems.api.Service.ProductOwnerService;
//import com.employeems.api.Service.ProductOwnerService;
import com.employeems.api.Service.TaskProductOwnerService;
import com.employeems.api.model.ProductOwner;
//import com.employeems.api.model.ProductOwner;
import com.employeems.api.model.TaskProductOwner;

@RestController
@RequestMapping("/api/task/owner")
public class TaskProductOwnerController {
	@Autowired
	private TaskProductOwnerService taskProductOwnerService;
	
	@Autowired
	private ProductOwnerService productOwnerService;
	
	@PostMapping("/add/{po_id}")
	public ResponseEntity<String> addTicket(@RequestBody TaskProductOwner taskProductOwner, @PathVariable("po_id") int po_id) {

	Optional<ProductOwner> optional = productOwnerService.getById(po_id);
	ProductOwner productOwner = optional.get();
	taskProductOwner.setProductOwner(productOwner);
	taskProductOwnerService.addTask(taskProductOwner);
	return ResponseEntity.status(HttpStatus.OK).body("Task Added");
	}
	
	
}