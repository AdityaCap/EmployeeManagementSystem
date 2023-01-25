package com.employeems.api.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.employeems.api.Enums.Gender;

@Entity
@Table(name="employees")
public class Employee 
{
	@Override
    public String toString() {
        return "Employee [emp_id=" + emp_id + ", name=" + name + ", city=" + city + ", salary=" + salary
                + ", joiningDate=" + joiningDate + ", gender=" + gender + ", designation=" + designation + ", domain="
                + domain + ", domain_id=" + domain_id + "]";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_city")
    private String city;
    @Column(name = "emp_salary")
    private double salary;
    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "emp_joining_date")
    private LocalDate joiningDate;
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;
    @Column(name = "designation")
    private String designation;
    @Column(name = "domain")
    private String domain;
    @Column(name = "domain_id")
    private int  domain_id;
    public int getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public int  getDomain_id() {
        return domain_id;
    }
    public void setDomain_id(int domain_id) {
        this.domain_id = domain_id;
    }
    public Employee(int emp_id, String name, String city, double salary, LocalDate joiningDate, Gender gender,
            String designation, String domain, int domain_id) {
        super();
        this.emp_id = emp_id;
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.gender = gender;
        this.designation = designation;
        this.domain = domain;
        this.domain_id = domain_id;
    }
}
