package com.wipro.factory;

import com.wipro.service.IEmployeeService;
import com.wipro.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
	private static IEmployeeService empService;
	static {
		empService=new EmployeeServiceImpl();
	}
	
	public static IEmployeeService getEmployeeService() {
		return empService;
	}
	
}

