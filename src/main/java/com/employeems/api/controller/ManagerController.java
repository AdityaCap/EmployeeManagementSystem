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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeems.api.Service.EmployeeService;
import com.employeems.api.Service.ManagerService;
import com.employeems.api.Service.TicketService;
import com.employeems.api.model.Employee;
import com.employeems.api.model.Manager;
import com.employeems.api.model.Ticket;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TicketService ticketService;
	
	
	
	
	@PostMapping("add/{eid}/{tid}")
	public ResponseEntity<String> addEmployeeTicketInManager(@RequestBody Manager manager,@PathVariable("tid") int tid,@PathVariable("eid") int eid
							) {
		//Fetch Department Object based on did. 
	Optional<Employee> optional= employeeService.getById(eid);
	Optional<Ticket> optional1=ticketService.getTicketById(tid);
		Employee employee=optional.get();
		Ticket ticket=optional1.get();
		//Attach department object to employee
		manager.setEmployee(employee);
		manager.setTicket(ticket);
		
		//save the employee object
		managerService.addManager(manager); 
		
		return ResponseEntity.status(HttpStatus.OK).body("Manager Posted..");
	}
	
	
	
	
	
	
//	@PostMapping("add/{eid}")
//	public ResponseEntity<String> addEmployeeInManager(@RequestBody Manager manager,@PathVariable("eid") int eid
//							) {
//		//Fetch Department Object based on did. 
//	Optional<Employee> optional= employeeService.getById(eid);
//	
//		Employee employee=optional.get();
//		
//		//Attach department object to employee
//		manager.setEmployee(employee);
//		
//		
//		//save the employee object
//		managerService.addManager(manager); 
//		
//		return ResponseEntity.status(HttpStatus.OK).body("Manager Posted..");
//	}
	
	
	
	
	
	
	@GetMapping("/getall")
    public List<Manager>  getAllManager()
    {
		List<Manager> list=managerService.getAllManager();
            return list;
    }
	
	
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Object>getMangerById(@PathVariable("id") int id){
		Optional<Manager>optional=managerService.getManagerById(id);
		if(!optional.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
		
		
		Manager manager=optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(manager);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteManager(@PathVariable("id") int id) {
	   managerService.deleteEmployeeById(id);
	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manager Deleted");
	}

	
	
	@PutMapping("/edit/{m_id}")
	public ResponseEntity<String> editManager(@PathVariable("m_id") int m_id, 
							@RequestBody Manager manager) {
		/* Step 1: check if this id given is valid by fetching the record from DB */
		Optional<Manager> optional = managerService.getManagerById(m_id);

		if(!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid ID");
		}

		Manager managerDB = optional.get(); //User given employee value

		/* Step 2: Set New value to DB value */
		if(manager.getM_name() != null)
			managerDB.setM_name(manager.getM_name());
		if(manager.getM_city() != null)
			managerDB.setM_city(manager.getM_city());
		if(manager.getM_salary() != 0.0)
			managerDB.setM_salary(manager.getM_salary());
		


		/* Save updated employeeDB value in DB */
		managerService.addManager(managerDB);
		return ResponseEntity.status(HttpStatus.OK).body("Employee record Edited..");

	}
	

}
