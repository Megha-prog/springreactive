package com.nkdebug.springreactive.dao;


import com.nkdebug.springreactive.dto.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class EmployeeDao {


    private static void sleepExecution(int i)  {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }
    public List<Employee> getEmployees() {
        return IntStream.rangeClosed(1,50)
                .peek(EmployeeDao::sleepExecution)
                .peek(data -> System.out.println("employee count: " + data))
                .mapToObj(data -> new Employee(data, "employee"+data))
                .collect(Collectors.toList());
    }

    public Flux<Employee> getEmployeesAsync() {
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(data -> System.out.println("employee count: " + data))
                .map(data -> new Employee(data, "employee"+data));
    }
}
