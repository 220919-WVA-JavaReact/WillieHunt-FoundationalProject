package com.revature.project.service;

import com.revature.project.dao.EmployeeDao;
import com.revature.project.dao.EmployeeDaoImp;
import com.revature.project.model.Employee;

import java.util.Scanner;

public class EmployeeService {
    EmployeeDao ed = new EmployeeDaoImp();
    Scanner sc = new Scanner(System.in);

    public Employee login(){
        System.out.println("Please enter in your Username");
        String username = sc.nextLine();
        System.out.println("Please enter in your Password");
        String password = sc.nextLine();

        Employee emp = ed.getByUsername(username);

        if(emp.getPassword().equals(password)){
            System.out.println("You have logged in Successfully!");
            return emp;
        }else {
            System.out.println("Unsuccessful login. Please try again");
            return null;
        }
    }

    public Employee register(){
        System.out.println("Enter in your First name");
        String first = sc.nextLine();
        System.out.println("Enter in your Last name");
        String last = sc.nextLine();
        System.out.println("Create a Username");
        String username = sc.nextLine();
        System.out.println("Create a Password");
        String password = sc.nextLine();

        System.out.println("New User created");
        Employee employee = ed.registerEmployee(first,last,username,password);
        return employee;
    }





}
