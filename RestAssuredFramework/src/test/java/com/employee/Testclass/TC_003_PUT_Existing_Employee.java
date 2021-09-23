package com.employee.Testclass;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.Baseclass.Baseclass;
import com.employee.Utility.RestUtils;
import com.github.cliftonlabs.json_simple.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_003_PUT_Existing_Employee extends Baseclass{
	String name=RestUtils.Name();
	   String job=RestUtils.Job();
	
	@BeforeClass
	void GetALLEmployee()
	{  
		log.info("-----------------started post single employee---------------");
		RestAssured.baseURI="https://reqres.in/";
	    httprequest=RestAssured.given();
	    JsonObject reuestParam=new JsonObject();
		reuestParam.put("name", name);
		reuestParam.put("job", job);
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(reuestParam.toJson());
	    response=httprequest.request(Method.PUT,"/api/users/"+EMPID);
		
	}
	@Test
	public void ResponseBody()
	{
		log.info("-------------cheking the response body--------------");
		String responseBody=response.getBody().asString();
		log.info("response body---"+responseBody);
		Assert.assertEquals(responseBody.contains("name"), true);
		Assert.assertEquals(responseBody.contains("job"), true);
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
		
		Assert.assertTrue(time<=2400);
			
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
		Assert.assertEquals(Encoding,"gzip");
	}
	
	
	
	
	
	@AfterClass
	public void close()
	{
		log.info("---------------------------closed postsingle employee------------------");
	}
	
	
}
