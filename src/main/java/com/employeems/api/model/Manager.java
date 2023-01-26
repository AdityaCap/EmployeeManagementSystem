package com.employeems.api.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int m_id;
	 @Column(name = "Manager_name")
	 private String m_name;
	
	 @Column(name="man_city")
	 private String m_city;
		public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_city() {
		return m_city;
	}
	public void setM_city(String m_city) {
		this.m_city = m_city;
	}
	public double getM_salary() {
		return m_salary;
	}
	public void setM_salary(double m_salary) {
		this.m_salary = m_salary;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
		
	private double m_salary;
		
		public Manager(int m_id, String m_name, String m_city, double m_salary) {
			super();
			this.m_id = m_id;
			this.m_name = m_name;
			this.m_city = m_city;
			this.m_salary = m_salary;
			
		}
		public Ticket getTicket() {
			return ticket;
		}
		public void setTicket(Ticket ticket) {
			this.ticket = ticket;
		}
		public Manager() {
			super();
		}
		
		
	@Override
		public String toString() {
			return "Manager [m_id=" + m_id + ", m_name=" + m_name + ", m_city=" + m_city + ", m_salary=" + m_salary
					 + "]";
		}
	
	@ManyToOne
	private Employee employee;
	
	@OneToOne
	 private Ticket ticket;
	

}




