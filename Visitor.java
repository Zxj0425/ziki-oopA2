package com.a2;

public class Visitor extends Person {
    private String ticketNumber;
    private boolean membershipStatus;

    // Default Constructor
    public Visitor() {
    }

    // Parameterized Constructor
    public Visitor(String name, int age, String address, String ticketNumber, boolean membershipStatus) {
        super(name, age, address); // Call the superclass constructor
        this.ticketNumber = ticketNumber;
        this.membershipStatus = membershipStatus;
    }

    // Getters and Setters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", membershipStatus=" + membershipStatus +
                '}';
    }
}