// Employee.java
package com.organization.leavemanagement.model;

public class Employee {
    private final String employeeId;
    private final String name;
    private int leaveBalance;
    private int totalLeavesTakenThisYear;

    public Employee(String employeeId, String name, int leaveBalance) {
        this.employeeId = employeeId;
        this.name = name;
        this.leaveBalance = leaveBalance;
        this.totalLeavesTakenThisYear = 0;
    }

    public String getEmployeeId() { return employeeId; }
    public int getLeaveBalance() { return leaveBalance; }
    public int getTotalLeavesTakenThisYear() { return totalLeavesTakenThisYear; }

    public void deductLeaveBalance(int days) {
        this.leaveBalance -= days;
        this.totalLeavesTakenThisYear += days;
    }
}