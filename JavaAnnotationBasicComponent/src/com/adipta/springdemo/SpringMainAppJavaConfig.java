package com.adipta.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adipta.springdemo.configuration.AppConfig;

public class SpringMainAppJavaConfig 
{
	public static void main(String[] args) 
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		SingletonStudent st1=context.getBean("singletonStudent", SingletonStudent.class);
		st1.setName("adipta");
		st1.setAge(26);
		
		SingletonStudent st2=context.getBean("singletonStudent", SingletonStudent.class);
		
		if(st1==st2)
		{
			System.out.println("Pointing to same object");
		}
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st1.getTeacher().getSubject());
		System.out.println(st1.getTeacher1().getSubject());
		
		System.out.println(st1.getEmail());;
		
//		context.stop();//Destroy is never called. Never use.
		
//		context.close();//Very harsh, sparingly use.
		
		context.registerShutdownHook();
	}
}