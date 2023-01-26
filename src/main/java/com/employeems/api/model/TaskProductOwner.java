package com.employeems.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TaskProductOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "t_name")
	private String t_name;
	@Column(name = "t_category")
	private String t_category;
	
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

	@ManyToOne
	private ProductOwner productOwner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public ProductOwner getProductOwner() {
		return productOwner;
	}

	public void setProductOwner(ProductOwner productOwner) {
		this.productOwner = productOwner;
	}
}