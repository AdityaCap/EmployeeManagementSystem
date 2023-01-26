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

import com.employeems.api.Enums.TicketStatus;
import com.employeems.api.Service.ManagerService;
import com.employeems.api.Service.TicketManagerService;
import com.employeems.api.Service.TicketService;
import com.employeems.api.model.Employee;
import com.employeems.api.model.Manager;
import com.employeems.api.model.Ticket;
import com.employeems.api.model.TicketManager;

@RestController
@RequestMapping("/api/ticketmanager")
public class TicketManagerController {
	@Autowired
	private TicketManagerService ticketManagerService;
	@Autowired
	private TicketService ticketService;
	
	
	@PostMapping("add/{tid}")
	public ResponseEntity<String> postManager(@RequestBody TicketManager ticketManager,@PathVariable("tid") int tid
							) {
		//Fetch Department Object based on did. 
	
	Optional<Ticket> optional1=ticketService.getTicketById(tid);
		
		Ticket ticket=optional1.get();
		//Attach department object to employee
		
		ticketManager.setTicket(ticket);
		
		//save the employee object
		ticketManagerService.addTicketManager(ticketManager); 
		
		return ResponseEntity.status(HttpStatus.OK).body("TicketRecieved");
	}
	
	
	@GetMapping("/getall")
	public List<TicketManager> getAllManagerTickets() {
		List<TicketManager> list = ticketManagerService.getAllManagerTickets();
		return list;
	}
	
	
	
	
	@GetMapping("/one/{tm_id}")
	public ResponseEntity<Object>getTicketManagerById(@PathVariable("id") int tm_id){
		Optional<TicketManager>optional=ticketManagerService.getTicketById(tm_id);
		if(!optional.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
		
		
		TicketManager ticketManager=optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ticketManager);
	}
	
	
	
	
	@PutMapping("/edit/{tm_id}")
	public ResponseEntity<String> editTicket(@PathVariable("tm_id") int tm_id, 
							@RequestBody TicketManager ticketManager) {
		/* Step 1: check if this id given is valid by fetching the record from DB */
		Optional<TicketManager> optional = ticketManagerService.getTicketById(tm_id);

		if(!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid ID");
		}

		TicketManager ticketManagerDB = optional.get(); //User given employee value

		/* Step 2: Set New value to DB value */
		if(ticketManager.getTicketStatus()!=null) {
			ticketManagerDB.getTicket().setTicketStatus(ticketManager.getTicketStatus());
			ticketManagerDB.setTicketStatus(ticketManager.getTicketStatus());
		
		}

		/* Save updated employeeDB value in DB */
		ticketManagerService.addTicketManager(ticketManagerDB);
		return ResponseEntity.status(HttpStatus.OK).body("Ticket record Edited..");

	}
	
	
	
	@DeleteMapping("/delete/{t_id}")
	
	public ResponseEntity<String> deleteManager(@PathVariable("t_id") int t_id) {
	   ticketManagerService.deleteTicketById(t_id);
	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ticket Deleted");
	}

	

	
}
