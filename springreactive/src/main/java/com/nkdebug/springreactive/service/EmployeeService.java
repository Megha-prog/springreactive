package com.nkdebug.springreactive.service;

import com.nkdebug.springreactive.dao.EmployeeDao;
import com.nkdebug.springreactive.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeDao dao;

    public List<Employee> getEmployees() {
        long sartTime = System.currentTimeMillis();
        List<Employee> employees = dao.getEmployees();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time :"+ (endTime-sartTime));
        return employees;
    }

    public Flux<Employee> getEmployeesAsync() {
        long sartTime = System.currentTimeMillis();
        Flux<Employee> employees = dao.getEmployeesAsync();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time :"+ (endTime-sartTime));
        return employees;
    }

}
