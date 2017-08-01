package com.task.util;

import com.task.model.Employee;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dmitriy Lyashenko
 */
@Component
public class CollectionGenerator {

    private List<Employee> employees = new LinkedList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> generateCollection(Integer capacity){
        employees.add(new Employee("Dima", "Lyashenko", "Manager", "Kiev", 2000));
        return getEmployees();
    }

}
