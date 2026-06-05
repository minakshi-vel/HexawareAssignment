//SickLeavePolicy.java
package com.organization.leavemanagement.policy;

import com.organization.leavemanagement.model.*;

public class SickLeavePolicy implements LeavePolicy {
    @Override
    public void validateLeave(Employee employee, LeaveRequest request) {
        if (employee.getLeaveBalance()<request.getRequestedDays()) throw new RuntimeException("Insufficient sick leave balance.");
    }
}