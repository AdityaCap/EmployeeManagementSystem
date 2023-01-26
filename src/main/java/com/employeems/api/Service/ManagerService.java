package com.employeems.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.employeems.api.model.Employee;
import com.employeems.api.model.Manager;
import com.employeems.api.Data.EmployeeRepo;
import com.employeems.api.Data.ManagerRepo;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepo managerRepo;
	@Autowired
	private EmployeeRepo employeeRepo;

	public void addManager(Manager manager) {
// TODO Auto-generated method stub
		managerRepo.save(manager);
	}
	public Employee getEmployeeById(int eid) {
		Optional<Employee> optional =employeeRepo.findById(eid);
		
		//if department exists, optional will not be null 
		if(optional != null)
			 return optional.get(); //returning the deprtment
		//if department does not exist, optional will be null 
		
		return null;
	}
	public List<Manager> getAllManager() {
		return managerRepo.findAll();
	}
	
	
	
	public Optional<Manager>getManagerById(int id){
		Optional<Manager>optional=managerRepo.findById(id);
		return optional;
	}
	
	
	
	
	
	public void deleteEmployeeById(int id) {
	      managerRepo.deleteById(id);
	   }
	public void deleteManager(Manager m) {
		
		managerRepo.delete(m);
	}

}
