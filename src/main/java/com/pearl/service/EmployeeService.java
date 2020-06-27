package com.pearl.service;


import com.pearl.model.Address;
import com.pearl.model.Employee;
import com.pearl.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);
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

    public List<Employee> createDump() {
        int d = 99;
        System.out.println("count"+ d);
        for (int i = 9; i < d; i++) {
            List<Address> addressList = new ArrayList<>();
            for (int j = 1; j < 3; j++) {
                Address address = Address.builder()
                        .city("city_" + j)
                        .street("street_" + j)
                        .build();
                addressList.add(address);
            }

            Employee employee = Employee.builder()
                    .firstName("first_" + i)
                    .lastName("last_" + i)
                    .email("email_" + i)
                    .mobile("mobile_" + i)
                    .addresses(addressList)
                    .build();
    logger.info("Employee :"+employee);
            employeeRepository.save(employee);
            logger.info("Employee saved successfully id: "+ employee.getId());
        }

        return employeeRepository.findAll();
    }
}
