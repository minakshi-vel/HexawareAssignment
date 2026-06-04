// MainApplication.java
package com.organization.leavemanagement.main;

import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.repository.EmployeeRepository;
import com.organization.leavemanagement.service.LeaveManagementService;

public class MainApplication {
    public static void main(String[] args) {
        EmployeeRepository repo = new EmployeeRepository();
        LeaveManagementService service = new LeaveManagementService(repo);

        repo.save(new Employee("EMP101", "Alice", 15));

        try {
            service.applyLeave("EMP101", "CASUAL", 3, "Personal work");
            System.out.println("Leave processed successfully.");
            
            // This second transaction fails cleanly due to consecutive rule assertions
            service.applyLeave("EMP101", "SICK", 10, "Flu");
        } catch (Exception e) {
            System.out.println("Error Handled in Main Layer: " + e.getMessage());
        }
    }
}