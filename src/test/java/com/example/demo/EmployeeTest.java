package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employees = new ArrayList<>();

        employees.add(new Employee(1, "Tiger Nixon", 320800, 61, ""));
        employees.add(new Employee(2, "Garrett Winters", 170750, 63, ""));
        employees.add(new Employee(3, "Ashton Cox", 86000, 66, ""));
        employees.add(new Employee(24, "Doris Wilder", 85600, 23, ""));
    }

    @Test
    void testGetAge() {
        Employee employee = new Employee(1, "Tiger Nixon", 320800, 61, "");
        Assertions.assertEquals(61, employee.getAge());
    }

    @Test
    void testFindOldestEmployee() {
        Employee oldestEmployee = EmployeeUtils.findOldestEmployee(employees);
        Assertions.assertEquals(66, oldestEmployee.getAge());
        Assertions.assertEquals("Ashton Cox", oldestEmployee.getEmployeeName());
    }
}
