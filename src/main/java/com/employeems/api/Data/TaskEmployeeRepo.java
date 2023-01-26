package com.employeems.api.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeems.api.model.TaskEmployee;

public interface TaskEmployeeRepo extends JpaRepository<TaskEmployee, Integer>{

}
