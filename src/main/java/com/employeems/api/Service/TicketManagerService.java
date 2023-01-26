package com.employeems.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeems.api.Data.TicketManagerRepo;
import com.employeems.api.Data.TicketRepo;
import com.employeems.api.model.Ticket;
import com.employeems.api.model.TicketManager;

@Service
public class TicketManagerService {
	@Autowired
	private TicketRepo ticketRepo;
	@Autowired
	private TicketManagerRepo ticketManagerRepo;
	
	
	public void addTicketManager(TicketManager ticketManager) {
		// TODO Auto-generated method stub
				ticketManagerRepo.save(ticketManager);
			}
	
	public  List<TicketManager> getAllManagerTickets() 
    {	        
    	return ticketManagerRepo.findAll();
    }
    
    public Optional<TicketManager> getTicketById(int t_id) 
	{
		Optional<TicketManager> optional=ticketManagerRepo.findById(t_id);
		
		return optional;
	}
    public void deleteTicketById(int t_id) 
	{			
    	ticketManagerRepo.deleteById(t_id);			
	}
}
