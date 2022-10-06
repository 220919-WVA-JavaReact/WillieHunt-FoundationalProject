package com.revature.project.dao;

import com.revature.project.ConnectionUtil;
import com.revature.project.model.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImp implements TicketDao{
    @Override
    public boolean createTicket(Ticket ticket) {

        Ticket tick = new Ticket();
        try (Connection conn = (Connection) ConnectionUtil.getConnection()){
            String sql = "INSERT INTO reimburseticket (amount, description, employee_id) VALUES (?,?,?) RETURNING *";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ticket.getAmount());
            stmt.setString(2, ticket.getDescription());
            stmt.setInt(3, ticket.getEmployeeId());
            ResultSet rs;
            if ((rs = stmt.executeQuery()) != null){
                while (rs.next()){
                    int id = rs.getInt("ticket_num");
                    int amount = rs.getInt("amount");
                    String description = rs.getString("description");
                    int employeeId = rs.getInt("employee_id");
                    tick = new Ticket(id, amount, description, employeeId);
                    return true;
                }

            }


        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
        return false;
    }


    @Override
    public List<Ticket> viewAllTicketsByEmployeeId(int employeeId) {

            List<Ticket> tickets = new ArrayList<>();

            try (Connection conn = ConnectionUtil.getConnection();) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM reimburseticket WHERE employee_id = ?";
                PreparedStatement stamt = conn.prepareStatement(sql);
                stamt.setInt(1, employeeId);

                ResultSet rs;

                if ((rs = stamt.executeQuery()) != null) {


                    while (rs.next()) {
                        int id = rs.getInt("ticket_num");
                        int amount = rs.getInt("amount");
                        String description = rs.getString("description");
                        int receivedEmployeeId = rs.getInt("employee_id");
                        Ticket tick = new Ticket(id, amount, description, employeeId);

                        tickets.add(tick);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return tickets;

        }


}
