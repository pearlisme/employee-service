package com.pearl.repository;

import com.pearl.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Iterable<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Employee> findByFirstName(String firstName);

    Iterable<Employee> findByLastName(String lastName);

    Employee findFirstByFirstName(String firstName);

    List<Employee> findByFirstNameLike(String firstName);

    List<Employee> findByFirstNameNotLike(String firsName);

    Long countByFirstNameLike(String firstName);

    List<Employee> findByFirstNameIs(String firsName);

    List<Employee> findByFirstNameEquals(String firsName);

    List<Employee> findByFirstNameNot(String firsName);

    List<Employee> findByFirstNameStartingWith(String firsName);
    List<Employee> findByFirstNameEndingWith(String firsName);
    List<Employee> findByFirstNameContaining(String firsName);

    List<Employee> findByIdLessThan(Long id);
    List<Employee> findByIdGreaterThan(Long id);

    List<Employee> findByIdLessThanEqual(Long id);
    List<Employee> findByIdGreaterThanEqual(Long id);
    List<Employee> findByIdLessThanAndIdGreaterThan(Long lid,Long gid);




}
