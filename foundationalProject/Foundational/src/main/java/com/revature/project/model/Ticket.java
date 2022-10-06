package com.revature.project.model;

import java.util.Objects;

public class Ticket {

    private int ticketNum;
    private int amount;
    private String description;
    private int employeeId;


    public Ticket(int ticketNum, int amount, String description, int employeeId) {
        this.ticketNum = ticketNum;
        this.amount = amount;
        this.description = description;
        this.employeeId = employeeId;
    }

    public Ticket() {
    }

    public Ticket(int amount, String description, int employeeId) {
        this.amount = amount;
        this.description = description;
        this.employeeId = employeeId;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployee(String employee) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNum=" + ticketNum +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketNum == ticket.ticketNum && amount == ticket.amount && employeeId == ticket.employeeId && description.equals(ticket.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketNum, amount, description, employeeId);
    }
}
