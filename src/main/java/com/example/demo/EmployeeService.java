//package com.example.demo;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Service
//public class EmployeeService {
//    private final String API_URL = "https://dummy.restapiexample.com/api/v1/employees";
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Employee[] getAllEmployees() throws JsonProcessingException {
//        ResponseEntity<String> response = restTemplate.getForEntity(API_URL, String.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        EmployeeResponse employeeResponse = objectMapper.readValue(response.getBody(), EmployeeResponse.class);
//        Employee[] employees = employeeResponse.getData();
//        System.out.print(employees);
//        return employees;
//    }
//
//    public Employee getOldestEmployee() throws JsonProcessingException {
//        Employee[] employees = getAllEmployees();
//        Employee oldestEmployee = employees[0];
//
//        for (Employee employee : employees) {
//            if (employee.getEmployeeAge() > oldestEmployee.getEmployeeAge()) {
//                oldestEmployee = employee;
//            }
//        }
//
//        return oldestEmployee;
//    }
//}
//
//
