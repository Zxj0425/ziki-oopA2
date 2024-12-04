package com.a2;

public class Employee extends Person {
    private String employeeId;
    private String position;

    // Default Constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String name, int age, String address, String employeeId, String position) {
        super(name, age, address); // Call the superclass constructor
        this.employeeId = employeeId;
        this.position = position;
    }

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}