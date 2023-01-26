package com.employeems.api.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeems.api.Enums.TicketStatus;
import com.employeems.api.Service.EmployeeService;
import com.employeems.api.Service.TicketService;
import com.employeems.api.model.Employee;
import com.employeems.api.model.Ticket;

@RestController
@RequestMapping("/api/ticket")

public class TicketController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add/{eid}")
	public ResponseEntity<String> addTicket(@RequestBody Ticket ticket, @PathVariable("eid") int eid) {

		Optional<Employee> optional = employeeService.getById(eid);
		Employee employee = optional.get();
		ticket.setEmployee(employee);
		ticketService.addTicket(ticket);
		return ResponseEntity.status(HttpStatus.OK).body("Ticket Added");
	}

	@GetMapping("/getall")
	public List<Ticket> getAllTickets() {
		List<Ticket> list = ticketService.getAllTickets();
		return list;
	}

	@GetMapping("/one/{e_id}")
	public ResponseEntity<Object> addEmployee(@RequestBody Ticket ticket,@PathVariable("e_id") int e_id) {
		Optional<Employee> optional = employeeService.getById(e_id);
		if (!optional.isPresent()) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
		}
		Employee employee = optional.get();
		 ticket.setEmployee(employee);
		ticketService.addTicket(ticket);
		return ResponseEntity.status(HttpStatus.OK).body("ticket posted..");
	}
	
	
	@GetMapping("/tem/{e_id}")
	public ResponseEntity<String> getTicketById(@PathVariable("e_id") int e_id) {
		List<Ticket> tList = ticketService.getAllTickets();
		for(Ticket t:tList) {
			if(t.getEmployee().getEmp_id()==e_id) {
				return ResponseEntity.status(HttpStatus.OK).body(t.getT_name());
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
	}
	
	
	@GetMapping("/tes/{t_status}")
	public ResponseEntity<Object> getTicketByStatus(@PathVariable("t_status") TicketStatus ticketStatus) {
		List<Ticket> tList = ticketService.getAllTickets();
		List<Ticket>newList=new ArrayList<>();
		for(Ticket t:tList) {
			if(t.getTicketStatus()==ticketStatus) {
				newList.add(t);
			}
		}
		if(newList!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(newList);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Status Given");
	}
	
	

	@DeleteMapping("/delete/{t_id}")
	public ResponseEntity<String> deleteTicket(@PathVariable("t_id") int t_id) {
		ticketService.deleteTicketById(t_id);
		return ResponseEntity.status(HttpStatus.OK).body("Ticket deleted successfully");
	}}
