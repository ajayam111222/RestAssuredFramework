package com.employee.Testclass;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.employee.Baseclass.Baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_Get_All_Employee extends Baseclass{

	
	
	@BeforeClass
	void GetALLEmployee()
	{  
		log.info("-----------------started Get all employee---------------");
		RestAssured.baseURI="http://dummy.restapiexample.com";
	    httprequest=RestAssured.given();
		response=httprequest.request(Method.GET,"/api/v1/employees");
		
	}
	
	@Test
	public void checkresponseBody()
	{
		log.info("--------------checking the response body-----------------");
		String responsebody=response.getBody().asString();
		log.info("Response body----"+responsebody);
		Assert.assertTrue(responsebody!=null);
		
	}
	@Test
	public void CheckResponseCode()
	{
		log.info("--------------checking the status code-----------------");
		int statuscode=response.getStatusCode();
		log.info("status code is--"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
	}
	@Test
	public void statusLine()
	{
		log.info("--------------checking the status line-----------------");
		String statusline=response.getStatusLine();
		log.info("status line is--"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
	}
	@Test
	public void CheckStatusTime()
	{
		log.info("--------------checking the status time-----------------");
		long time=response.getTime();
		log.info("status time--"+time);
		if(time>=2000)
		log.info("status time is wrong ");
		
		Assert.assertTrue(time<=2000);
			
	}
	@Test
	public void CheckContentType()
	{
		log.info("--------------checking the header content-----------------");
		String content=response.header("Content-Type");
		log.info("content type--"+content);
		Assert.assertEquals(content,"application/json");
		
	}
	@Test
	public void checkserver()
	{
		log.info("--------------checking the header content-----------------");
		String server=response.header("Server");
		log.info("content type--"+server);
		Assert.assertEquals(server,"cloudflare");
	}
	@Test
	public void CheckcontentEncoding()
	{
		log.info("--------------checking the header content-----------------");
		String Encoding=response.header("Content-Encoding");
		log.info("content type--"+Encoding);
		Assert.assertEquals(Encoding,"gzip");
	}
	
	
	
	
	@AfterClass
     void tearDown()
	{
		
		log.info("-------------------Closed all Get employee--------------------");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
