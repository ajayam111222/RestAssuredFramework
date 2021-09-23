package com.employee.Utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String Name()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return("Ajay"+generatedstring);
	}
	public static String Job()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return("Tester"+generatedstring);
	}

}
