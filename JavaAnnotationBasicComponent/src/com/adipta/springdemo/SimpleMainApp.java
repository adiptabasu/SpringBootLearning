package com.adipta.springdemo;

public class SimpleMainApp 
{
	public static void main(String[] args) 
	{
		SingletonStudent st=null;
		st=new SingletonStudent("t1", 1);
		System.out.println(st);
	}

}
