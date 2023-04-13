package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface EmployeeService {
    public String getOldestEmployeeName() throws JsonProcessingException;
}
