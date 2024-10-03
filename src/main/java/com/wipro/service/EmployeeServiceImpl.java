package com.wipro.service;

import com.wipro.bean.Employee;
import com.wipro.dao.IEmployeeDao;
import com.wipro.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements IEmployeeService {
    
    @Override
    public String addEmployee(Employee emp) {
        IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
        return empDao.add(emp);
    }

    @Override
    public Employee searchEmployee(int eno) {
        IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
        return empDao.search(eno);
    }

    @Override
    public String updateEmployee(Employee emp) {
        IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
        return empDao.update(emp);
    }

    @Override
    public String deleteEmployee(int eno) {
        IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
        return empDao.delete(eno);
    }
}
