package com.pearl.service;


import com.pearl.model.Employee;
import com.pearl.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void findFirstByFirstName(){

        Employee employee = employeeRepository.findFirstByFirstName("first_500");
        Assert.assertEquals("first_500",employee.getFirstName());
    }

    @Test
    public void findByFirstNameIs(){

        List<Employee> employees = employeeRepository.findByFirstNameIs("first_500");
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertEquals("first_500",employees.stream().findFirst().get().getFirstName());
    }
    @Test
    public void findByFirstNameNot(){

        List<Employee> employees = employeeRepository.findByFirstNameNot("first_500");
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertNotEquals("first_500",employees.stream().findFirst().get().getFirstName());
    }
    @Test
    public void findByFirstNameEquals(){

        List<Employee> employees = employeeRepository.findByFirstNameEquals("first_500");
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertEquals("first_500",employees.stream().findFirst().get().getFirstName());
    }

    @Test
    public void findByFirstNameLike(){

        List<Employee> employees = employeeRepository.findByFirstNameLike("first_2500");
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertTrue(employees.stream().count() >0);
    }

    @Test
    public void findByFirstNameNotLike(){

        List<Employee> employees = employeeRepository.findByFirstNameNotLike("first_");
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertNotEquals("first_500",employees.stream().findFirst().get().getFirstName());
    }

    @Test
    public void findByFirstNameStartingWith(){

        List<Employee> employees = employeeRepository.findByFirstNameStartingWith("first_");
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertNotEquals("first_500",employees.stream().findFirst().get().getFirstName());
    }
    @Test
    public void findByFirstNameEndingWith(){

        List<Employee> employees = employeeRepository.findByFirstNameEndingWith("9");
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertNotEquals("first_500",employees.stream().findFirst().get().getFirstName());
    }
    @Test
    public void findByFirstNameContaining(){

        List<Employee> employees = employeeRepository.findByFirstNameContaining("first_");
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertNotEquals("first_500",employees.stream().findFirst().get().getFirstName());
    }
    @Test
    public void findByIdLessThan(){

        List<Employee> employees = employeeRepository.findByIdLessThan(2500L);
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertTrue(employees.stream().count() > 0);
    }

    @Test
    public void findByIdLessThanEqual(){

        List<Employee> employees = employeeRepository.findByIdLessThanEqual(2500L);
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertTrue(employees.stream().count() > 0);
    }

    @Test
    public void findByIdGreaterThan(){

        List<Employee> employees = employeeRepository.findByIdGreaterThan(2500L);
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertTrue(employees.stream().count() > 0);
    }

    @Test
    public void findByIdGreaterThanEqual(){

        List<Employee> employees = employeeRepository.findByIdGreaterThanEqual(2500L);
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertTrue(employees.stream().count() > 0);
    }

    @Test
    public void findByIdLessThanAndIdGreaterThan(){

        List<Employee> employees = employeeRepository.findByIdLessThanAndIdGreaterThan(3000L,2000L);
        System.out.println("employees.stream().count(): "+employees.stream().count());
        Assert.assertTrue(employees.stream().count() > 0);
    }



}