package com.revature.project.service;

import com.revature.project.dao.TicketDao;
import com.revature.project.dao.TicketDaoImp;
import com.revature.project.model.Employee;
import com.revature.project.model.Ticket;

import java.util.List;
import java.util.Scanner;

public class TicketService {

    TicketDao td = new TicketDaoImp();
    Scanner sc = new Scanner(System.in);


    public void createTicket(Employee employee){
        System.out.println("Enter the Amount number");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.println("Add Description");
        String description = sc.nextLine();

        Ticket ticket = new Ticket(amount, description, employee.getEmployeeId());

        boolean successful = td.createTicket(ticket);

        if (successful){
            System.out.println("Successfully created a Reimbursement Ticket");
        }else {
            System.out.println("Something went wrong");
        }
    }

    public void viewAllTicketsByEmployeeId(int employeeId) {
        System.out.println("Viewing all Tickets");

        List<Ticket> ticketList = td.viewAllTicketsByEmployeeId(employeeId);

        // Print each value of the list
        for (Ticket ticket : ticketList) {
            System.out.println(ticket);
        }
    }

}
