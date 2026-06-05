// Main.java
package com.organization.leavemanagement;

import com.organization.leavemanagement.model.*;
import com.organization.leavemanagement.repository.LeaveRepository;
import com.organization.leavemanagement.service.LeaveService;

public class Main {
    public static void main(String[] args) {
        LeaveService service = new LeaveService();
        LeaveRepository repo = new LeaveRepository();

        // Testing a Permanent Employee with a valid Casual Leave
        Employee emp1 = new PermanentEmployee("P101", "Bob", 15);
        LeaveRequest req1 = new LeaveRequest("R01", emp1, 2, "casual");

        repo.save(req1);
        service.processLeave(req1);

        System.out.println("Execution Status: " + req1.getStatus());
        System.out.println("Remaining Leaves: " + emp1.getLeaveBalance());
    }
}