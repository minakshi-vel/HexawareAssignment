// Employee.java
package com.organization.leavemanagement.model;

public abstract class Employee {
    private String employeeId;
    private String name;
    protected int leaveBalance;

    public Employee(String employeeId, String name, int leaveBalance) {
        this.employeeId = employeeId;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }

    public abstract int calculateMaxAllowedLeave();
    public int getLeaveBalance() { return leaveBalance; }
    public void deductLeave(int days) { this.leaveBalance -= days; }
}