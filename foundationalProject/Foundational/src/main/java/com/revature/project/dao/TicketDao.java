package com.revature.project.dao;

import com.revature.project.model.Ticket;

import java.util.List;

public interface TicketDao {

    boolean createTicket(Ticket ticket);

    List<Ticket> viewAllTicketsByEmployeeId(int employeeId);

}
