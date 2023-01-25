package com.employeems.api.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeems.api.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> 
{

}
