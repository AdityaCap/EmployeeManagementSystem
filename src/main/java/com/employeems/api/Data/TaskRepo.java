package com.employeems.api.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeems.api.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>{

}
