package com.adipta.springdemo.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.adipta.springdemo")
@PropertySource("classpath:sport.properties")
public class AppConfig 
{

}