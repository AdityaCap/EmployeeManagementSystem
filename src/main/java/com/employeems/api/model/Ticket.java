package com.employeems.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.employeems.api.Enums.Gender;
import com.employeems.api.Enums.TicketStatus;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int t_id;

	@ManyToOne
	private Employee employee;

	@Column(name = "t_name")
	private String t_name;
	@Column(name = "t_category")
	private String t_category;
	
	@Enumerated(EnumType.STRING)
    @Column(name="ticket_status")
    private TicketStatus ticketStatus;

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_category() {
		return t_category;
	}

	public void setT_category(String t_category) {
		this.t_category = t_category;
	}

	public Ticket(int t_id, Employee employee, String t_name, String t_category, TicketStatus ticketStatus) {
		super();
		this.t_id = t_id;
		this.employee = employee;
		this.t_name = t_name;
		this.t_category = t_category;
		this.ticketStatus = ticketStatus;
	}
	
	public Ticket() {
		super();
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	@Override
	public String toString() {
		return "Ticket [t_id=" + t_id + ", t_name=" + t_name + ", t_category=" + t_category + "]";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}