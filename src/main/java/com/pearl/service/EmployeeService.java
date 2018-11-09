package com.pearl.service;


import com.pearl.model.Employee;
import com.pearl.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addStudent(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Optional<Employee> findStudentById(Long id) {
        return employeeRepository.findById(id);
    }


    public Iterable<Employee> findByNames(String firstName, String lastName) {

        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Iterable<Employee> findAll() {

        return employeeRepository.findAll();
    }

    public Iterable<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public Iterable<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    public Employee deleteStudent(Long id) {

        Optional<Employee> student = findStudentById(id);

        if (student.get() != null) {
            employeeRepository.delete(student.get());

            return student.get();
        }
        return null;
    }
}
