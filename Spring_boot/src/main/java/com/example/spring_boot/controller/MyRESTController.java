package com.example.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.spring_boot.entity.Employee;
import com.example.spring_boot.exception_handling.NoSuchEmployeeException;
import com.example.spring_boot.sevice.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return  allEmployees;
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee (@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if(employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = "
                    + id + " in DataBase");
        }
        return employee; // в теле запроса будет не сам объект а его представление в JSON
    }

    @PostMapping("/employees")
    public Employee addNewEmployee (@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee (@RequestBody Employee employee) {

        if(employee == null) {
            throw new NoSuchEmployeeException("There is no such employee in DataBase");
        }
        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = "
                    + id + " in DataBase");
        }

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }




}
