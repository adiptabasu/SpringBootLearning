package com.adipta.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adipta.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{
//	No need to write any implementation class. We get it from JPARepository.
}