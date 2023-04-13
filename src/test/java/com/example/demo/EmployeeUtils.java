package com.example.demo;

import java.util.List;

public class EmployeeUtils {

    public static Employee findOldestEmployee(List<Employee> employees) {
        Employee oldestEmployee = null;
        for (Employee employee : employees) {
            if (oldestEmployee == null || employee.getAge() > oldestEmployee.getAge()) {
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }
}
