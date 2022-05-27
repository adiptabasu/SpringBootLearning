package com.adipta.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.adipta.springboot.cruddemo.entity.Employee;

//@RepositoryRestResource(path = "members")//Thos is used for custom api path name, otherwise,plural of class is uesed, employees 
public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{
//	No need to write any implementation class. We get it from JPARepository.
}