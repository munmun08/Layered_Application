package com.wipro.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import com.wipro.bean.Employee;
import com.wipro.factory.EmployeeServiceFactory;
import com.wipro.service.IEmployeeService;

public class Test {

    public static void main(String[] args) {
        BufferedReader br = null;
        IEmployeeService empService = null;
        int eno = 0;
        String ename = "";
        float esal = 0.0f;
        String eaddr = "";
        String status = "";
        int option = 0;

        br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.println();
                System.out.println("1. ADD EMPLOYEE");
                System.out.println("2. SEARCH EMPLOYEE");
                System.out.println("3. UPDATE EMPLOYEE");
                System.out.println("4. DELETE EMPLOYEE");
                System.out.println("5. EXIT");
                System.out.print("ENTER YOUR OPTION [1, 2, 3, 4, 5]: ");

                option = Integer.parseInt(br.readLine());

                switch (option) {
                    case 1:
                        System.out.println("=========== EMPLOYEE ADD MODULE ===========");
                        System.out.print("Employee Number             : ");
                        eno = Integer.parseInt(br.readLine());
                        System.out.print("Employee Name               : ");
                        ename = br.readLine();
                        System.out.print("Employee Salary             : ");
                        esal = Float.parseFloat(br.readLine());
                        System.out.print("Employee Address            : ");
                        eaddr = br.readLine();

                        Employee emp = new Employee();
                        emp.setEno(eno);
                        emp.setEname(ename);
                        emp.setEsal(esal);
                        emp.setEaddr(eaddr);

                        empService = EmployeeServiceFactory.getEmployeeService();
                        status = empService.addEmployee(emp);
                        if (status.equalsIgnoreCase("success"))
                            System.out.println("Status: Employee Inserted Successfully");
                        else if (status.equalsIgnoreCase("failure"))
                            System.out.println("Status: Employee Insertion Failed");
                        else
                            System.out.println("Status: Employee Already Exists");
                        break;

                    case 2:
                        System.out.println("=========== EMPLOYEE SEARCH MODULE ===========");
                        System.out.print("Enter Employee Number to Search: ");
                        eno = Integer.parseInt(br.readLine());

                        empService = EmployeeServiceFactory.getEmployeeService();
                        Employee searchEmp = empService.searchEmployee(eno);
                        if (searchEmp != null) {
                            System.out.println("Employee Found:");
                            System.out.println("Employee Number  : " + searchEmp.getEno());
                            System.out.println("Employee Name    : " + searchEmp.getEname());
                            System.out.println("Employee Salary  : " + searchEmp.getEsal());
                            System.out.println("Employee Address : " + searchEmp.getEaddr());
                        } else {
                            System.out.println("Employee Not Found.");
                        }
                        break;

                    case 3:
                        System.out.println("=========== EMPLOYEE UPDATE MODULE ===========");
                        System.out.print("Enter Employee Number to Update: ");
                        eno = Integer.parseInt(br.readLine());

                        empService = EmployeeServiceFactory.getEmployeeService();
                        Employee updateEmp = empService.searchEmployee(eno);

                        if (updateEmp != null) {
                            System.out.print("Enter New Employee Name    (Old: " + updateEmp.getEname() + "): ");
                            ename = br.readLine();
                            System.out.print("Enter New Employee Salary  (Old: " + updateEmp.getEsal() + "): ");
                            esal = Float.parseFloat(br.readLine());
                            System.out.print("Enter New Employee Address (Old: " + updateEmp.getEaddr() + "): ");
                            eaddr = br.readLine();

                            updateEmp.setEname(ename);
                            updateEmp.setEsal(esal);
                            updateEmp.setEaddr(eaddr);

                            status = empService.updateEmployee(updateEmp);
                            if (status.equalsIgnoreCase("success"))
                                System.out.println("Status: Employee Updated Successfully");
                            else
                                System.out.println("Status: Employee Update Failed");
                        } else {
                            System.out.println("Employee Not Found.");
                        }
                        break;

                    case 4:
                        System.out.println("=========== EMPLOYEE DELETE MODULE ===========");
                        System.out.print("Enter Employee Number to Delete: ");
                        eno = Integer.parseInt(br.readLine());

                        empService = EmployeeServiceFactory.getEmployeeService();
                        status = empService.deleteEmployee(eno);
                        if (status.equalsIgnoreCase("success"))
                            System.out.println("Status: Employee Deleted Successfully");
                        else
                            System.out.println("Status: Employee Deletion Failed or Employee Not Found.");
                        break;

                    case 5:
                        System.out.println("*************** Thank you for using the Employee Application ***************");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("WRONG CHOICE! PLEASE ENTER A VALID OPTION.");
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
