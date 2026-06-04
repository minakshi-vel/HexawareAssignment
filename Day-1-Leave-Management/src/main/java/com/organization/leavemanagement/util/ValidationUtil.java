// ValidationUtil.java
package com.organization.leavemanagement.util;

import com.organization.leavemanagement.exception.InvalidLeaveRequestException;
import com.organization.leavemanagement.model1.LeaveType;

public class ValidationUtil {
    public static void validateString(String val, String field) {
        if (val == null || val.trim().isEmpty()) throw new InvalidLeaveRequestException(field + " is blank");
    }
    public static void validatePositiveNumber(int val, String field) {
        if (val <= 0) throw new InvalidLeaveRequestException(field + " must be > 0");
    }
    public static void validateLeaveType(String typeStr) {
        validateString(typeStr, "Leave Type");
        try { LeaveType.valueOf(typeStr.toUpperCase().trim()); } 
        catch (IllegalArgumentException e) { throw new InvalidLeaveRequestException("Invalid type"); }
    }
}