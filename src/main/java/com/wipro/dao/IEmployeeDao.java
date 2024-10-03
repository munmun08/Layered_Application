package com.wipro.dao;

import com.wipro.bean.Employee;

public interface IEmployeeDao {
	public String add(Employee emp);
	public Employee search(int eno);
	public String update(Employee emp);
	public String delete(int eno);

}
