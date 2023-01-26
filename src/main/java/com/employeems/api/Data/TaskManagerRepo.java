package com.employeems.api.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeems.api.model.TaskManager;

public interface TaskManagerRepo extends JpaRepository<TaskManager, Integer>{

}
