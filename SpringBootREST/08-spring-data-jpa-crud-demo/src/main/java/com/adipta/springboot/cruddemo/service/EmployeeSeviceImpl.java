package com.adipta.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adipta.springboot.cruddemo.dao.EmployeeRepository;
import com.adipta.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeSeviceImpl implements EmployeeService 
{
	private EmployeeRepository employeeRepository;
	
//	For JPA Repository, transactional is not needed, as it is handled by JPA Repository
	
	@Autowired
	public EmployeeSeviceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository=employeeRepository;
	}

	@Override
	public List<Employee> findAll() 
	{
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) 
	{
//		Remember this, very important, took a lot of time to find the solution.
		System.out.println("Id is "+id);
		Optional<Employee> result=employeeRepository.findById(id);
		Employee employee=null;
		if(result.isPresent())
		{
			employee=result.get();
		}
		return employee;
	}

	@Override
	public void save(Employee employee) 
	{
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) 
	{
		employeeRepository.deleteById(id);;
	}

}
