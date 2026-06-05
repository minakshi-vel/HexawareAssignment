// LeaveRepository.java
package com.organization.leavemanagement.repository;

import com.organization.leavemanagement.model.LeaveRequest;
import java.util.ArrayList;
import java.util.List;

public class LeaveRepository {
    private List<LeaveRequest> requests = new ArrayList();  //Aggregation

    public void save(LeaveRequest request) { requests.add(request); }
    public List<LeaveRequest> getAllRequests() { return requests; }
}