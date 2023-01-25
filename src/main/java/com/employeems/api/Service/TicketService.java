package com.employeems.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeems.api.Data.EmployeeRepo;
import com.employeems.api.Data.TicketRepo;
import com.employeems.api.model.Employee;
import com.employeems.api.model.Ticket;

@Service
public class TicketService {
	 @Autowired
	    private  TicketRepo ticketRepo;
	 
	 @Autowired
	    private  EmployeeRepo employeeRepo;
	
	 
	    public   void addTicket(Ticket ticket) 
	    {
	        ticketRepo.save(ticket);
	    }
	    
	    public  List<Ticket> getAllTickets() 
	    {	        
	    	return ticketRepo.findAll();
	    }
	    
	    public Optional<Ticket> getTicketById(int t_id) 
		{
			Optional<Ticket> optional=ticketRepo.findById(t_id);
			
			return optional;
		}
	    
	    public Employee getEmployeeById(int t_id) 
		{
			Optional<Employee> optional= employeeRepo.findById(t_id);
			
			if (optional!=null) {
				return optional.get();
			}
			
			return null;
		}
	    
	    public void deleteTicketById(int t_id) 
		{			
			ticketRepo.deleteById(t_id);			
		}
	    
	    
}