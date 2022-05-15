package com.adipta.springdemo.legacyXML;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LegacyXMLMainApp 
{
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContextLegacy.xml");
		
		StudentLegacy sl1=context.getBean("studentLegacy", StudentLegacy.class);
		
		sl1.setName("Manish");
		sl1.setAge(25);
		
		System.out.println(sl1);
		
		System.out.println(sl1.getTeacherLegacy().getSubject());
		
		context.registerShutdownHook();
	}
}
