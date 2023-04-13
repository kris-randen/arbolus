package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Comparator;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    private final String API_URL = "https://dummy.restapiexample.com/api/v1/employees";

    public Employee[] getAllEmployees() throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(API_URL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeResponse employeeResponse = objectMapper.readValue(response.getBody(), EmployeeResponse.class);
        Employee[] employees = employeeResponse.getData();
        System.out.print(employees);
        return employees;
    }

    public Employee getOldestEmp() throws JsonProcessingException {
        Employee[] employees = getAllEmployees();
        Employee oldestEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee.getEmployeeAge() > oldestEmployee.getEmployeeAge()) {
                oldestEmployee = employee;
            }
        }

        return oldestEmployee;
    }

    @GetMapping("/oldestEmployee")
    public String getOldestEmployee() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(API_URL, String.class);

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Parse the JSON string into a JsonNode object
        JsonNode rootNode = objectMapper.readTree(result);

        // Extract the "data" array from the JsonNode object
        JsonNode dataArray = rootNode.get("data");

        // Convert the data array to a list of Employee objects
        List<Employee> employees = objectMapper.convertValue(dataArray, new TypeReference<>() {
        });

        // Find the oldest employee
        Employee oldestEmployee = employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);

        return oldestEmployee.getEmployeeName();
    }
}
