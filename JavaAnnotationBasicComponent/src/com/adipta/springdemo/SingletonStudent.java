package com.adipta.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.adipta.springdemo.teacher.Teacher;

//@Component("theFuckingStudent")
@Component
@Scope("singleton")
public class SingletonStudent 
{
	private String name;
	private float age;
	
	@Value("${foo.email}")
	private String email;
	
	@Autowired
	@Qualifier("mathTeacher")
	private Teacher teacher;
	
	@Autowired
	@Qualifier("historyTeacher")
	private Teacher teacher1;
	
	public SingletonStudent(String name, float age) 
	{
		this.name = name;
		this.age = age;
	}
	
	public SingletonStudent()
	{
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public float getAge() 
	{
		return age;
	}

	public void setAge(float age) 
	{
		this.age = age;
	}
	
	public String getEmail() 
	{
		return email;
	}

	public Teacher getTeacher() 
	{
		return teacher;
	}

	public Teacher getTeacher1() 
	{
		return teacher1;
	}

	@Override
	public String toString() 
	{
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	@PostConstruct
	public void doSomethingBefore() 
	{
		System.out.println("Inside doSomethingBefore");
	}
	
	@PreDestroy
	public void doSomethingAfter()
	{
		System.out.println("Inside doSomethingAfter");
	}
}