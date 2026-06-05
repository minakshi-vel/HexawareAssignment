// LeaveRequest.java
package com.organization.leavemanagement.model;

public class LeaveRequest {
    private String requestId;
    private Employee employee; // Association
    private int requestedDays;
    private String type; 
    private LeaveStatus status = LeaveStatus.PENDING;

    public LeaveRequest(String requestId, Employee employee, int requestedDays, String type) {
        this.requestId = requestId;
        this.employee = employee;
        this.requestedDays = requestedDays;
        this.type = type;
    }

    public Employee getEmployee() { return employee; }
    public int getRequestedDays() { return requestedDays; }
    public String getType() { return type; }
    public LeaveStatus getStatus() { return status; }
    public void setStatus(LeaveStatus status) { this.status = status; }
}