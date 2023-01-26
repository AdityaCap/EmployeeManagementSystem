package com.employeems.api.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employeems.api.model.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {
	}
