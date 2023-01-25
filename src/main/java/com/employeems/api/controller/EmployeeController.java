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
  	public ResponseEntity<Object> getInstructorById(@PathVariable("id") int id)
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
}