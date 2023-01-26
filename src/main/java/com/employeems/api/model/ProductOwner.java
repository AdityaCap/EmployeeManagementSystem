package com.employeems.api.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductOwner {

	public ProductOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductOwner [po_id=" + po_id + ", po_name=" + po_name + ", po_city=" + po_city + "]";
	}

	public String getPo_name() {
		return po_name;
	}

	public void setPo_name(String po_name) {
		this.po_name = po_name;
	}

	public String getPo_city() {
		return po_city;
	}

	public void setPo_city(String po_city) {
		this.po_city = po_city;
	}

	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int po_id;
	
//	@ManyToOne
//	private Task task;
//	
//	public Task getTask() {
//		return task;
//	}
//
//	public void setTask(Task task) {
//		this.task = task;
//	}

	@Column(name = "po_name")
     private String po_name;
	 
	 @Column(name="po_city")
	 private String po_city;

	public int getPo_id() {
		return po_id;
	}

	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}
}
