package com.tw.apistackbase.controller;

import com.tw.apistackbase.models.Employee;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeResource() {
        employeeList.add(new Employee(0, "Xiaoming", 20, "Male"));
        employeeList.add(new Employee(1, "Xiaohong", 19, "Female"));
        employeeList.add(new Employee(2, "Xiaozhi", 15, "Male"));
        employeeList.add(new Employee(3, "Xiaogang", 16, "Male"));
        employeeList.add(new Employee(4, "Xiaoxia", 15, "Female"));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeList);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        Employee nullEmployee = new Employee(-1, "unknown name", -1, "unknown gender");
        return ResponseEntity.ok(employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findAny()
                .orElse(nullEmployee));
    }
}
