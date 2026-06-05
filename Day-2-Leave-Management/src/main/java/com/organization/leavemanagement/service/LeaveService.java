// LeaveService.java
package com.organization.leavemanagement.service;

import com.organization.leavemanagement.model.*;
import com.organization.leavemanagement.policy.*;

public class LeaveService {
    // Composition
    private final LeavePolicy casualPolicy = new CasualLeavePolicy();
    private final LeavePolicy sickPolicy = new SickLeavePolicy();
    private final LeavePolicy earnedPolicy = new EarnedLeavePolicy();

    public void processLeave(LeaveRequest request) {
        Employee emp = request.getEmployee();
        try {
            switch (request.getType().toLowerCase()) {
                case "casual" -> casualPolicy.validateLeave(emp, request);
                case "sick" -> sickPolicy.validateLeave(emp, request);
                case "earned" -> earnedPolicy.validateLeave(emp, request);
                default -> throw new IllegalArgumentException("Invalid leave type.");
            }
            emp.deductLeave(request.getRequestedDays());
            request.setStatus(LeaveStatus.APPROVED);
        } catch (Exception e) {
            request.setStatus(LeaveStatus.REJECTED);
            System.out.println("Workflow Rejected: " + e.getMessage());
        }
    }
}