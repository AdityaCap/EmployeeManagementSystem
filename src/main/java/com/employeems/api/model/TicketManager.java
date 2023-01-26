package com.employeems.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.employeems.api.Enums.TicketStatus;

@Entity
@Table(name="TicketManager")
public class TicketManager {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tm_id;
	@OneToOne
	 private Ticket ticket;
	public int getTm_id() {
		return tm_id;
	}
	public void setTm_id(int tm_id) {
		this.tm_id = tm_id;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_status")
    private TicketStatus ticketStatus;
	
	
	
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	
	
}
