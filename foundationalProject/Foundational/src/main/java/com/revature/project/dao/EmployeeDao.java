package com.revature.project.dao;

import com.revature.project.model.Employee;

public interface EmployeeDao {

    Employee getByUsername(String username);
    Employee registerEmployee(String first, String last, String username, String password);
}
