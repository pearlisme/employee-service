package com.pearl.repository;

import com.pearl.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Iterable<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Employee> findByFirstName(String firstName);

    Iterable<Employee> findByLastName(String lastName);
}
