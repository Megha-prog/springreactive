package com.nkdebug.springreactive.controller;


import com.nkdebug.springreactive.dto.Employee;
import com.nkdebug.springreactive.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class WebFluxController {

    @Autowired
    private EmployeeService employeeService;


    /**
     *
     * Blocking & Synchronous [Traditional REST API]
     * */
    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     *
     * Non Blocking & Asynchronous
     * */
    @GetMapping(value = "/getEmployeesAsync", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> getEmployeesAsync() {
        return employeeService.getEmployeesAsync();
    }



}
