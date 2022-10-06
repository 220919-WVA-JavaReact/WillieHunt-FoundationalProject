package com.revature.project.model;

import java.util.Objects;

public class Employee {

    private int employeeId;
    private String first;
    private String last;
    private String username;
    private String password;
    // private boolean manager; true is are false if not
    public Employee(int employeeId, String first, String last, String username, String password) {
        this.employeeId = employeeId;
        this.first = first;
        this.last = last;
        this.username = username;
        this.password = password;
    }

    public Employee() {
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && first.equals(employee.first) && last.equals(employee.last) && username.equals(employee.username) && password.equals(employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, first, last, username, password);
    }
}
