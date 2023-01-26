package com.employeems.api.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeems.api.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
