package com.revature.project.dao;

import com.revature.project.ConnectionUtil;
import com.revature.project.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImp implements EmployeeDao {
    @Override
    public Employee getByUsername(String username) {
        Employee employee = new Employee();

        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM employee WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null) {
                rs.next();
                int receivedId = rs.getInt("employee_id");
                String receivedFirst = rs.getString("first");
                String receivedLast = rs.getString("last");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("password");

                employee = new Employee(receivedId, receivedFirst, receivedLast, receivedUsername, receivedPassword);

            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
        return employee;
    }


    @Override
    public Employee registerEmployee(String first, String last, String username, String password) {
        Employee employee = new Employee();

        try (Connection conn =  ConnectionUtil.getConnection()) {

            String sql = "INSERT INTO employee (first, last, username, password) VALUES (?,?,?,?) RETURNING *";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setString(3, username);
            stmt.setString(4, password);

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null) {
                rs.next();
                int receivedId = rs.getInt("employee_id");
                String receivedFirst = rs.getString("first");
                String receivedLast = rs.getString("last");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("password");

                employee = new Employee(receivedId, receivedFirst, receivedLast, receivedUsername, receivedPassword);

            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
        return employee;
    }
}
