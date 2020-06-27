package com.pearl.controller;

import com.pearl.model.Employee;
import com.pearl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public Iterable<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping(value = "/add")
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.create(employee);
    }

    @PostMapping(value = "/update")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.update(employee);
    }

    @GetMapping("/find/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/search")
    public Iterable<Employee> findEmployeeByFirstAndLastName(@RequestParam(value = "first", required = false) String firstName,
                                                             @RequestParam(value = "last", required = false) String lastName) {

        return employeeService.search(firstName, lastName);

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Employee deleteEmployee(@PathVariable Long id) {

        return employeeService.delete(id);


    }

    @GetMapping(value = "/dump")
    public List<Employee> addEmployee() {

        return employeeService.createDump();
    }

}
