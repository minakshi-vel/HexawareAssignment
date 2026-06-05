//EarnedLeavePolicy.java
package com.organization.leavemanagement.policy;

import com.organization.leavemanagement.model.*;

public class EarnedLeavePolicy implements LeavePolicy {
    @Override
    public void validateLeave(Employee employee, LeaveRequest request) {
        if (request.getRequestedDays() <5) throw new IllegalArgumentException("Earned leave must be minimum 5 days.");
        if (employee.getLeaveBalance() <request.getRequestedDays()) throw new RuntimeException("Insufficient balance.");
    }
}