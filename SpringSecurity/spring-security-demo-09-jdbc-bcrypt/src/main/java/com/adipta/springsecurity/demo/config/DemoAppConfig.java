package com.adipta.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.adipta.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig implements WebMvcConfigurer
{
//	Setting up a variable to hold the properties
	@Autowired
	private Environment env;
	
//	Setting up logger for diagnostics
	private Logger logger=Logger.getLogger(getClass().getName());
	
	//Defining a Bean for View Resolver
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	}
	
	@Bean
	public DataSource securityDataSource()
	{
//		Create Connection Pool
		ComboPooledDataSource securityDataSource
			= new ComboPooledDataSource();
				
//		Set the JDBC Driver Class
		try 
		{
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) 
		{
			throw new RuntimeException(e);
		}
		
//		Log the Connection Props
		logger.info("jdbc.url>>>>>>>"+env.getProperty("jdbc.url"));
		logger.info("jdbc.user>>>>>>>"+env.getProperty("jdbc.user"));

//		Set the Database Connection Props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
//		Set the Connection Pool Props
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
//	Helper method, to read property, and convert to integer
	private int getIntProperty(String propertyName)
	{
		String propVal=env.getProperty(propertyName);
		
		int intPropVal=0;
		
		try
		{
			intPropVal=Integer.parseInt(propVal);
		}
		catch(Exception ex)
		{
			intPropVal=0;
		}
		return intPropVal;
	}
}