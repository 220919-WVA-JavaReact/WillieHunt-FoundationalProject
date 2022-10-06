package com.revature.project;

import com.revature.project.model.Employee;
import com.revature.project.service.EmployeeService;
import com.revature.project.service.TicketService;

import java.util.Scanner;

public class MainLogin {

    static Scanner sc = new Scanner(System.in);
    static EmployeeService es = new EmployeeService();
    static TicketService ts = new TicketService();

    public static void main(String[] args) {

        Employee loggedInUser = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Press 1 to login, Press 2 to Register");
        int choice = sc.nextInt();

        if (choice == 1){
            loggedInUser = es.login();
        }else if (choice == 2){
            loggedInUser = es.register();
        }else {
            System.out.println("Invalid Inupt");
        }

        while (loggedInUser != null){
            // if (eloggedInUser is not a manager) do this menu
            System.out.println("Press 1 to create Reimburement Ticket or 2 to view Tickets");
            int nextChoice = sc.nextInt();
            switch (nextChoice){
                case 1:
                    ts.createTicket(loggedInUser);
                    break;
                case 2:
                    ts.viewAllTicketsByEmployeeId(loggedInUser.getEmployeeId());
                    break;
                default:
                    System.out.println("Something went wrong");
            }
            // else do this menu

        }

    }
}
