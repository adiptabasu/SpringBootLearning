package com.adipta.springbootdemo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController 
{
	@Value(value = "${coach.name}")
	private String coachName;
	
	@Value(value = "${team.name}")
	private String teamName;
	
	@GetMapping(path = "/")
	public String sayHello()
	{
		return "Hello world, the current time is:+"+LocalDateTime.now();
	}
	
	@GetMapping(path = "/workout")
	public String getDailyWorkout()
	{
		return "Run 5K";
	}
	
	@GetMapping(path = "/fortune")
	public String getDailyFortune()
	{
		return "Today is your lucky day.";
	}
	
	@GetMapping(path = "/teaminfo")
	public String getTeamInfo()
	{
		return "Coach name is:"+this.coachName+" and the team name is:"+this.teamName;
	}
}