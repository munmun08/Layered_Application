package com.wipro.factory;

import com.wipro.dao.IEmployeeDao;
import com.wipro.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
	private static IEmployeeDao empDao;
	static {
		empDao=new EmployeeDaoImpl();
	}
	
	public static IEmployeeDao getEmployeeDao() {
		return empDao;
	}
	
}
