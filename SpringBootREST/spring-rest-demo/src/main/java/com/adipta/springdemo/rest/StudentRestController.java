package com.adipta.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adipta.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController 
{
	private List<Student> students=null;
	@PostConstruct
	public void postConstructCall()
	{
		students=new ArrayList<Student>();
		
		students.add(new Student("Adipta", "Basu"));
		students.add(new Student("Aritra", "Basu"));
		students.add(new Student("Sagnik", "Sarkar"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{	
		return this.students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) throws StudentNotFoundException
	{
		if(studentId>=students.size())
		{
			throw new StudentNotFoundException("Student id not found");
		}
		return students.get(studentId);
	}
	
//	Methods moved to StudentRestExceptionHandler, to check exceptions globally
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
//	{
//		StudentErrorResponse error=new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
//	}
//	
////	This is basically a catch all for all exceptions
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc)
//	{
//		StudentErrorResponse error=new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
//	}
}