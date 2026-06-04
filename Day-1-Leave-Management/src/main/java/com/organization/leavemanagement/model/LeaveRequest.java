// LeaveRequest.java
package com.organization.leavemanagement.model;
import java.time.LocalDate;

public class LeaveRequest {
    private final String employeeId;
    private final LeaveType leaveType;
    private final int numberOfDays;
    private final String reason;
    private final LocalDate requestDate = LocalDate.now();

    public LeaveRequest(String employeeId, String leaveTypeStr, int numberOfDays, String reason) {
        this.employeeId = employeeId;
        this.leaveType = leaveTypeStr != null ? LeaveType.valueOf(leaveTypeStr.toUpperCase().trim()) : null;
        this.numberOfDays = numberOfDays;
        this.reason = reason;
    }

    public LeaveType getLeaveType() { return leaveType; }
}