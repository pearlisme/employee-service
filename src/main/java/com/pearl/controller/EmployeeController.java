package com.pearl.controller;

import com.pearl.model.Employee;
import com.pearl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public Iterable<Employee> listStudents() {
        return employeeService.findAll();
    }

    @PostMapping(value = "/add")
    public Employee addStudent(@RequestBody Employee employee) {

        if (employee == null) return null;

        return employeeService.addStudent(employee);
    }

    @GetMapping("/find/{id}")
    public Optional<Employee> findStudentById(@PathVariable Long id) {
        return employeeService.findStudentById(id);
    }

    @GetMapping("/search")
    public Iterable<Employee> findStudentByFirstAndLastName(@RequestParam(value = "first", required = false) String firstName,
                                                            @RequestParam(value = "last", required = false) String lastName) {

        if (firstName != null & lastName != null) {
            return employeeService.findByNames(firstName, lastName);
        } else if (firstName != null) {
            return employeeService.findByFirstName(firstName);
        } else if (lastName != null) {
            return employeeService.findByLastName(lastName);
        } else
            return employeeService.findAll();

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Employee deleteStudent(@PathVariable Long id) {

        return employeeService.deleteStudent(id);


    }

}
