package com.adipta.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adipta.springboot.cruddemo.entity.Employee;
import com.adipta.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping(path = "/api")
public class EmployeeRestController 
{
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService)
	{
		this.employeeService=employeeService;
	}
	
	@GetMapping(path = "/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	@GetMapping(path = "/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		return employeeService.findById(employeeId);
	}
	
	@PostMapping(path = "/employees")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping(path = "/employees")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping(path = "/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		String message="Deleted employee with id="+employeeId;
		Employee tempEmployee=employeeService.findById(employeeId);
		if(tempEmployee==null)
		{
			message="Employee not found with id "+employeeId;
		}
		employeeService.deleteById(employeeId);
		return message;
	}
}