package com.adipta.springdemo.rest;

public class StudentNotFoundException extends Exception
{

	public StudentNotFoundException(String message, Throwable cause) 
	{
		super(message, cause);
	}

	public StudentNotFoundException(String message) 
	{
		super(message);
	}

	public StudentNotFoundException(Throwable cause) 
	{
		super(cause);
	}
	
}