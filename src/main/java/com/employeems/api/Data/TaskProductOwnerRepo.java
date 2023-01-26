package com.employeems.api.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeems.api.model.TaskProductOwner;

public interface TaskProductOwnerRepo extends JpaRepository<TaskProductOwner, Integer>{

}