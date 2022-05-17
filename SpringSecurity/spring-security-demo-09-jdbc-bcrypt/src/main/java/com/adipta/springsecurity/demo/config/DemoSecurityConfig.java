package com.adipta.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter 
{
//	Adding a reference to the security data source in DemoAppConfig
	@Autowired
	private DataSource securityDataSource;
	
	//This method is for creating default in memory users;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		//Adding our users for in memory authentication, for demo
		/*
		 * Removing JDBC Hard Coding
		UserBuilder users=User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE","FRESHER"))
			.withUser(users.username("mary").password("test123").roles("MANAGER","EMPLOYEE"))
			.withUser(users.username("susan").password("test123").roles("ADMIN","EMPLOYEE"));
		*/
//		bcrypt password plain text is fun123
		auth.jdbcAuthentication().dataSource(securityDataSource);
//		super.configure(auth);
	}

//	This method is to configure the web paths in application, for login, logout,etc.
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		
		http.authorizeRequests()
				.antMatchers("/css/**").permitAll()
//				.anyRequest().authenticated()
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied");
//		super.configure(http);
	}	
	
}