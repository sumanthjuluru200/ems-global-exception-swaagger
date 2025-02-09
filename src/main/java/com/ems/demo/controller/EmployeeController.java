package com.ems.demo.controller;

import com.ems.demo.entity.Employee;
import com.ems.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@Tag(name = "Employee Management", description = "Operations related to employees")
@RequestMapping("/api/ems")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @Operation(summary = "Create Employee", description = "Add a new employee to the system")
    @PostMapping("/save")
    public String addEmp(@RequestBody Employee employee){
        return employeeService.addEmp(employee);
    }

    @PutMapping("/update")
    @Operation(summary = "Update Employee", description = "Update the employee to the system")

    public String updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get All Employees", description ="Get all employees from the system" )
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmp();
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "Get Employee", description ="Get employee by ID from the system" )
    public Employee getById(@PathVariable("id") int id){

        return employeeService.getById(id);
    }
}
