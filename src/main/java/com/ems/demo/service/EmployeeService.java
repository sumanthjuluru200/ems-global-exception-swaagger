package com.ems.demo.service;

import com.ems.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public String addEmp(Employee employee);
    public String updateEmp(Employee employee);
    public List<Employee> getAllEmp();
    public Employee getById(int id);
    public void deleteById(int id);

}
