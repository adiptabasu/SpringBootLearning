package com.adipta.springdemo.legacyXML;

import org.springframework.stereotype.Component;

@Component
public class StudentLegacy 
{
	private String name;
	private float age;
	private String team;
	private String email;
	
	private TeacherLegacy teacherLegacy;
	
	public String getTeam() 
	{
		return team;
	}

	public void setTeam(String team) 
	{
		this.team = team;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
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

	public TeacherLegacy getTeacherLegacy() 
	{
		return teacherLegacy;
	}

	public void setTeacherLegacy(TeacherLegacy teacherLegacy) 
	{
		this.teacherLegacy = teacherLegacy;
	}

	public StudentLegacy(String name, float age, TeacherLegacy teacherLegacy) 
	{
		this.name = name;
		this.age = age;
		this.teacherLegacy = teacherLegacy;
	}
	
	public StudentLegacy()
	{
	}
	
	public void doingSomethingBefore()
	{
		System.out.println("Inside doing something before");
	}
	
	public void doingSomethingAfter()
	{
		System.out.println("Inside doing something after");
	}

	@Override
	public String toString() 
	{
		return "StudentLegacy [name=" + name + ", age=" + age + ", team=" + team + ", email=" + email
				+ ", teacherLegacy=" + teacherLegacy + "]";
	}
	
}