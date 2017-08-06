package com.task.service;

import com.task.dao.GeneratorRepository;
import com.task.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmitriy Lyashenko
 */
@Service
public class GeneratorService {

    private GeneratorRepository repository;

    public List<Employee> generate(Integer capacity){
        return repository.generate(capacity);
    }

    public List<Employee> getCollection(){
        return repository.getCollection();
    }

    public List<Employee> getCollectionFilterAnd(String name, String surname, String position, String city, Integer income) {
        List<Employee> employees = repository.getCollection();

        return employees.stream()
                .filter(employee -> (name == null || employee.getName().equals(name))
                        && (surname == null || employee.getSurname().equals(surname))
                        && (position == null || employee.getPosition().equals(position))
                        && (city == null || employee.getCity().equals(city))
                        && (income == null || employee.getIncome().equals(income)))
                .collect(Collectors.toList());
    }

    public List<Employee> getCollectionFilterOr(String name, String surname, String position, String city, Integer income) {
        List<Employee> employees = repository.getCollection();

        return employees.stream()
                .filter(employee -> employee.getName().equals(name)
                        || employee.getSurname().equals(surname)
                        || employee.getPosition().equals(position)
                        || employee.getCity().equals(city)
                        || employee.getIncome().equals(income))
                .collect(Collectors.toList());
    }

    @Autowired
    public void setRepository(GeneratorRepository repository) {
        this.repository = repository;
    }
}
