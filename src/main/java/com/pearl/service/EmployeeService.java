package com.pearl.service;


import com.pearl.model.Employee;
import com.pearl.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> findAll() {

        return employeeRepository.findAll();
    }

    public Employee create(@NotNull Employee employee) {


        return employeeRepository.save(employee);
    }

    public Employee update(@NotNull Employee employee) {

        Boolean employeeExist = findById(employee.getId()).isPresent();

        if(employeeExist) {
            return employeeRepository.save(employee);
        }else {
            return null;
        }
    }

    public Employee delete(Long id) {

        Optional<Employee> student = findById(id);

        if (student.get() != null) {
            employeeRepository.delete(student.get());

            return student.get();
        }
        return null;
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }


    public Iterable<Employee> search(String firstName, String lastName) {

        if (firstName != null & lastName != null) {
            return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
        } else if (firstName != null) {
            return employeeRepository.findByFirstName(firstName);
        } else if (lastName != null) {
            return employeeRepository.findByLastName(lastName);
        } else
            return null;
    }

}
