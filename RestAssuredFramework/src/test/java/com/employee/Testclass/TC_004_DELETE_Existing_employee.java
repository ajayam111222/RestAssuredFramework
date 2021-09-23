package com.employee.Testclass;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.Baseclass.Baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC_004_DELETE_Existing_employee extends Baseclass{

	@BeforeClass
	void DeleteExistingEmployee() throws InterruptedException
	{  
		log.info("-----------------started DELETE existing employee---------------");
		RestAssured.baseURI="https://reqres.in/";
	    httprequest=RestAssured.given();
	    
	    response=httprequest.request(Method.GET,"/api/users/");
	    
	    System.out.println(response);
	    
		JsonPath JsonpathEvalutor=response.jsonPath();
		String empid=JsonpathEvalutor.get("[0].id");// taking existing employeed id and delete
		System.out.println(empid);
		response=httprequest.request(Method.DELETE,"/api/users/"+EMPID);//delete the existing employeed id 
		
	Thread.sleep(2000);	
	}
	
	@Test
	public void checkresponsebody()
	{
	   String responsebody=	response.getBody().asString();
	   System.out.println("respnose budy is "+responsebody);
	}
	@Test
	public void chekingStatuscode()
	{
      int statuscode=response.getStatusCode(); 
		 log.info("status code-"+statuscode);
		 Assert.assertEquals(statuscode, 204);
	}
	@Test
	public void statusLine()
	{
		log.info("--------------checking the status line-----------------");
		String statusline=response.getStatusLine();
		log.info("status line is--"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 204 No Content");
		
	}
	@Test
	public void CheckStatusTime()
	{
		log.info("--------------checking the status time-----------------");
		long time=response.getTime();
		log.info("status time--"+time);
		if(time>=2000)
		log.info("status time is wrong ");
		
		Assert.assertTrue(time<=2400);
			
	}
	@Test()
	public void CheckContentType()
	{
		log.info("--------------checking the header content-----------------");
		String content=response.header("Content-Type");
		log.info("content type--"+content);
		Assert.assertEquals(content,null);
		
	}
	@Test
	public void checkserver()
	{
		log.info("--------------checking the server-----------------");
		String server=response.header("Server");
		log.info("content type--"+server);
		Assert.assertEquals(server,"cloudflare");
	}
	@Test
	public void CheckcontentEncoding()
	{
		log.info("--------------checking the contentEncoding-----------------");
		String Encoding=response.header("Content-Encoding");
		log.info("content type--"+Encoding);
		Assert.assertEquals(Encoding,null);
	}
	
	
	
	
	
	
	
	
	@AfterClass
	public void close()
	{
		log.info("---------------------------closed postsingle employee------------------");
	}
	
	
	
	
}
