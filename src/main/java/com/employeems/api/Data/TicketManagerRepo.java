package com.employeems.api.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeems.api.model.TicketManager;

public interface TicketManagerRepo extends JpaRepository<TicketManager, Integer> 
{

}
