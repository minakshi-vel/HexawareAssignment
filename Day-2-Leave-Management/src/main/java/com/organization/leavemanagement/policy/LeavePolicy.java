// LeavePolicy.java
package com.organization.leavemanagement.policy;

import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.model.LeaveRequest;

public interface LeavePolicy {
    void validateLeave(Employee employee, LeaveRequest request);
}