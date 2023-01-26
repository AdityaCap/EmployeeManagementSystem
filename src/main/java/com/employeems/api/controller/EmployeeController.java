package com.employeems.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeems.api.Service.EmployeeService;
import com.employeems.api.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController 
{
	@Autowired 
    private EmployeeService employeeService;
	
    @GetMapping("/hello")
    public String sayHello() {
        return "hello spring boot";
    }
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee)
    {
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body("Employee Added");
    }
    @GetMapping("/getall")
    public List<Employee>  getAllEmployees()
    {
            List<Employee> list=employeeService.getAllEmployees();
            return list;
    }
    //Get Employees via id
  	//Hence post mapping will be used
  	@PostMapping("/one/{id}")
  	public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id)
  	{
  		Optional<Employee> optional =employeeService.getById( id);
  		if(! optional.isPresent())
  		{
  			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
  		}
  		Employee employee=optional.get();
  		return  ResponseEntity.status(HttpStatus.OK).body(employee);
  	}
  	//Delete Employees by id
  	@DeleteMapping("/delete/{id}")
  	public void deleteEmployee(@PathVariable("id") int id) {
  	   employeeService.deleteEmployeeById(id);
  	   System.out.println("Employee Deleted Successfully");      
  	}
  	@PutMapping("/update/{eid}")
	public ResponseEntity<String> editEmployee(@PathVariable("eid") int eid, 
							@RequestBody Employee employeeNew) {
		/* Step 1: check if this id given is valid by fetching the record from DB */
		Optional<Employee> optional = employeeService.getEmployeeById(eid);

		if(!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid ID");
		}

		Employee employeeDB = optional.get(); //User given employee value

		/* Step 2: Set New value to DB value */
		if(employeeNew.getName() != null)
			employeeDB.setName(employeeNew.getName());
		if(employeeNew.getCity() != null)
			employeeDB.setCity(employeeNew.getCity());
		if(employeeNew.getSalary() != 0.0)
			employeeDB.setSalary(employeeNew.getSalary());
		if(employeeNew.getJoiningDate() != null)
			employeeDB.setJoiningDate(employeeNew.getJoiningDate());
		if(employeeNew.getGender() != null)
			employeeDB.setGender(employeeNew.getGender());
		if(employeeNew.getDesignation()!=null)
			employeeDB.setDesignation(employeeNew.getDesignation());
		if(employeeNew.getDomain()!=null)
			employeeDB.setDomain(employeeNew.getDomain());
		if(employeeNew.getDomain_id()!=0)
			employeeDB.setDomain_id(employeeNew.getDomain_id());
		
		/* Save updated employeeDB value in DB */
		employeeService.addEmployee(employeeDB);
		return ResponseEntity.status(HttpStatus.OK).body("Employee record Updated via employee id..");
	}
}