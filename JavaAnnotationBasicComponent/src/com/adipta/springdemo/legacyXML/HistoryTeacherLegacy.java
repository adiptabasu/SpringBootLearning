package com.adipta.springdemo.legacyXML;

import org.springframework.stereotype.Component;

@Component
public class HistoryTeacherLegacy implements TeacherLegacy
{

	@Override
	public String getSubject() 
	{
		return "I am History Teacher";
	}

}