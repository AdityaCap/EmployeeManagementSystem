package com.employeems.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int task_id;
	
	@Column(name = "Task_Name")
	private String task_name;
	@Column(name = "Task_Category")
	private String task_category;
	
	
	@ManyToOne
	private ProductOwner productOwner;
//	@OneToOne
//	private Employee employee;
//	@OneToOne
//	private Manager manager;
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getTask_category() {
		return task_category;
	}
	public void setTask_category(String task_category) {
		this.task_category = task_category;
	}
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//	public Manager getManager() {
//		return manager;
//	}
//	public void setManager(Manager manager) {
//		this.manager = manager;
//	}
//	public Task(int task_id, String task_name, String task_category, Employee employee, Manager manager) {
//		super();
//		this.task_id = task_id;
//		this.task_name = task_name;
//		this.task_category = task_category;
//		this.employee = employee;
//		this.manager = manager;
//	}
	
	public Task() {
		super();
	}
//	@Override
//	public String toString() {
//		return "Task [task_id=" + task_id + ", task_name=" + task_name + ", task_category=" + task_category
//				+ ", employee=" + employee + ", manager=" + manager + "]";
//	}
//	
	public Task(int task_id, String task_name, String task_category, ProductOwner productOwner) {
		super();
		this.task_id = task_id;
		this.task_name = task_name;
		this.task_category = task_category;
		this.productOwner = productOwner;
	}
	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_name=" + task_name + ", task_category=" + task_category
				+ ", productOwner=" + productOwner + "]";
	}
	
	
}
