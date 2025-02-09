package com.ems.demo.serviceimpl;

import com.ems.demo.entity.Employee;
import com.ems.demo.exception.EmployeeAlreadyExistException;
import com.ems.demo.exception.NoSuchEmployeeExistsException;
import com.ems.demo.repository.EmployeeRepository;
import com.ems.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String addEmp(Employee employee) {

        Optional<Employee> isExistEmail=employeeRepository.findByEmail(employee.getEmail());
        Optional<Employee> isExistName=employeeRepository.findByName(employee.getName());
        if (isExistEmail.isPresent()) {
            throw new EmployeeAlreadyExistException("Employee already exist with mail id " + employee.getEmail());
        }
        if(isExistName.isPresent()){
            throw new EmployeeAlreadyExistException("Employee already exit with name "+employee.getName());

        }else{
            employeeRepository.save(employee);
            return "Employee Saved Succefully id - "+employee.getId();
        }

    }

    @Override
    public String updateEmp(Employee employee) {

        Employee isExistEmployee=employeeRepository.findById(employee.getId()).orElseThrow(()->new NoSuchEmployeeExistsException("No such employee exist with id "+employee.getId()));

            isExistEmployee.setName(employee.getName());
            isExistEmployee.setEmail(employee.getEmail());
            isExistEmployee.setCity(employee.getCity());
            employeeRepository.save(isExistEmployee);
            return "Employee updates succesfully "+employee;
        }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public String getById(int id) {
        return "";
    }

    @Override
    public void deleteById(int id) {
        Optional<Employee> isEmployeeExist=employeeRepository.findById(id);
        if (isEmployeeExist.isPresent()){
            employeeRepository.deleteById(id);
        }else{
        throw new NoSuchEmployeeExistsException("No such employee exist with id "+id);
    }
        }

}



