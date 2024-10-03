package com.wipro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.wipro.bean.Employee;
import com.wipro.factory.ConnectionFactory;

public class EmployeeDaoImpl implements IEmployeeDao {
    public static final String EMPLOYEE_INSERT_QUERY = "INSERT INTO employees VALUES (?,?,?,?)";
    public static final String EMPLOYEE_SEARCH_QUERY = "SELECT * FROM employees WHERE eno = ?";
    public static final String EMPLOYEE_UPDATE_QUERY = "UPDATE employees SET ename=?, esal=?, eaddr=? WHERE eno=?";
    public static final String EMPLOYEE_DELETE_QUERY = "DELETE FROM employees WHERE eno = ?";

    @Override
    public String add(Employee emp) {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pst = con.prepareStatement(EMPLOYEE_INSERT_QUERY)) {

            pst.setInt(1, emp.getEno());
            pst.setString(2, emp.getEname());
            pst.setFloat(3, emp.getEsal());
            pst.setString(4, emp.getEaddr());

            int result = pst.executeUpdate();
            return result != 0 ? "success" : "failure";
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        }
    }

    @Override
    public Employee search(int eno) {
        Employee emp = null;
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pst = con.prepareStatement(EMPLOYEE_SEARCH_QUERY)) {

            pst.setInt(1, eno);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    emp = new Employee();
                    emp.setEno(rs.getInt(1));
                    emp.setEname(rs.getString(2));
                    emp.setEsal(rs.getFloat(3));
                    emp.setEaddr(rs.getString(4));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public String update(Employee emp) {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pst = con.prepareStatement(EMPLOYEE_UPDATE_QUERY)) {

            pst.setString(1, emp.getEname());
            pst.setFloat(2, emp.getEsal());
            pst.setString(3, emp.getEaddr());
            pst.setInt(4, emp.getEno());

            int result = pst.executeUpdate();
            return result != 0 ? "success" : "failure";
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        }
    }

    @Override
    public String delete(int eno) {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pst = con.prepareStatement(EMPLOYEE_DELETE_QUERY)) {

            pst.setInt(1, eno);
            int result = pst.executeUpdate();
            return result != 0 ? "success" : "failure";
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        }
    }
}
