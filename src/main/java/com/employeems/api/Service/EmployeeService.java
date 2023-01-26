package com.employeems.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeems.api.Data.EmployeeRepo;
import com.employeems.api.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Optional<Employee> getById(int id) {
		Optional<Employee> optional = employeeRepo.findById(id);
		if (optional == null)
			return null;
		return optional;
	}

	public void deleteEmployeeById(int id) {
		employeeRepo.deleteById(id);
	}

	public Optional<Employee> getEmployeeById(int eid) {

		return employeeRepo.findById(eid);
	}
}
