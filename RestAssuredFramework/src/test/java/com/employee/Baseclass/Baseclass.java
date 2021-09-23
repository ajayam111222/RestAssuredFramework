package com.employee.Baseclass;

import java.util.logging.Logger;

import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	
	public static RequestSpecification httprequest;
	public static Response response;
	public String EMPID="2";
	public  Logger log;
	
	@BeforeClass
	public void Setup()
	{
		 log=Logger.getLogger("EmployeeRestApi");
		PropertyConfigurator.configure("./Log4jProperties/log4j.properties");
		log.setLevel(java.util.logging.Level.INFO);
		
		
		
		
		
	}

}
