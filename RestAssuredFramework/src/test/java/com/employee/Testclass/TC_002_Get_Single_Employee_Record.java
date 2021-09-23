package com.employee.Testclass;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.Baseclass.Baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_002_Get_Single_Employee_Record extends Baseclass
{
	
	
	@BeforeClass
	void GetALLEmployee()
	{  
		log.info("-----------------started Get single employee---------------");
		RestAssured.baseURI="https://reqres.in/";
	    httprequest=RestAssured.given();
		response=httprequest.request(Method.GET,"/api/users/"+EMPID);
		
	}
	
	@Test
	public void CheckSingleEmployee_firstname()
	{
		String Responsebody=response.getBody().asString();
		log.info("response body---"+Responsebody);
		
		Assert.assertEquals(Responsebody.contains("Janet"), true);
		
	}
	@Test
	public void chekingStatuscode()
	{
         int statuscode=response.getStatusCode(); 
		 log.info("status code-"+statuscode);
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
		Assert.assertEquals(content,"application/json; charset=utf-8");
		
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
	@Test(enabled=false)
	public void CheckContentLenght()
	{
		log.info("--------------checking the header content-----------------");
		String length=response.header("Content-Length");
		log.info("content type--"+length);
		Assert.assertTrue(Integer.parseInt(length)<1500);
	}
	
	
	
	@AfterClass
    void tearDown()
	{
		
		log.info("-------------------Closed all single employee--------------------");
		
	}
	
	
	
	
	
	
}
