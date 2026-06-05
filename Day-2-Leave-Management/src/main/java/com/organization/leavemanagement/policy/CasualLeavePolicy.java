// CasualLeavePolicy.java
package com.organization.leavemanagement.policy;

import com.organization.leavemanagement.model.*;

public class CasualLeavePolicy implements LeavePolicy {
    @Override
    public void validateLeave(Employee employee, LeaveRequest request) {
        if (request.getRequestedDays() > 3) throw new IllegalArgumentException("Casual leave limit exceeded (Max 3 days).");
        if (employee.getLeaveBalance() < request.getRequestedDays()) throw new RuntimeException("Insufficient balance.");
    }
}