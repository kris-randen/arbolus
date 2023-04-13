package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeResponse {
    private Employee[] data;
    private String status;
    private String message;

    public Employee[] getData() {
        return data;
    }

    public void setData(Employee[] data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

