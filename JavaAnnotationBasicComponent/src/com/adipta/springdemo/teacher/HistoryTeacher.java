package com.adipta.springdemo.teacher;

import org.springframework.stereotype.Component;

@Component
public class HistoryTeacher implements Teacher
{
	@Override
	public String getSubject() 
	{
		return "My subject is History";
	}
}
