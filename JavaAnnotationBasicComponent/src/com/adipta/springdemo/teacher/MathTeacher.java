package com.adipta.springdemo.teacher;

import org.springframework.stereotype.Component;

@Component
public class MathTeacher implements Teacher
{
	@Override
	public String getSubject() 
	{
		return "My subject is Maths";
	}
}
