// EmployeeRepository.java
package com.organization.leavemanagement.repository;

import com.organization.leavemanagement.model.Employee;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EmployeeRepository {
    // Justification: Option B (HashMap) chosen for O(1) continuous time key indexing search lookups.
    private final Map<String, Employee> employeeMap = new HashMap<>();

    public void save(Employee emp) { employeeMap.put(emp.getEmployeeId(), emp); }
    public Optional<Employee> findById(String id) { return Optional.ofNullable(employeeMap.get(id)); }
}