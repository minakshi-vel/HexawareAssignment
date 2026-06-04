// LeaveManagementService.java
package com.organization.leavemanagement.service;

import com.organization.leavemanagement.exception.*;
import com.organization.leavemanagement.model.*;
import com.organization.leavemanagement.repository.EmployeeRepository;
import com.organization.leavemanagement.util.ValidationUtil;

public class LeaveManagementService {
    private final EmployeeRepository repository;

    public LeaveManagementService(EmployeeRepository repository) { this.repository = repository; }

    public void applyLeave(String employeeId, String leaveTypeStr, int numberOfDays, String reason) {
        ValidationUtil.validateString(employeeId, "EmployeeId");
        ValidationUtil.validateLeaveType(leaveTypeStr);
        ValidationUtil.validatePositiveNumber(numberOfDays, "Days");
        ValidationUtil.validateString(reason, "Reason");

        Employee employee = repository.findById(employeeId.trim())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        LeaveRequest request = new LeaveRequest(employeeId, leaveTypeStr, numberOfDays, reason);
        if (request.getLeaveType() == LeaveType.SICK && numberOfDays > 5) {
            throw new InvalidLeaveRequestException("Max 5 consecutive sick leaves allowed");
        }
        if (numberOfDays > employee.getLeaveBalance()) {
            throw new InsufficientLeaveBalanceException("Insufficient balance");
        }
        if (employee.getTotalLeavesTakenThisYear() + numberOfDays > 20) {
            throw new InvalidLeaveRequestException("Cannot exceed 20 leave days in a year");
        }

        employee.deductLeaveBalance(numberOfDays);
    }
}