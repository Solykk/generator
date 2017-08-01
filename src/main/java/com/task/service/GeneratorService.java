package com.task.service;

import com.task.dao.GeneratorRepository;
import com.task.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    public void setRepository(GeneratorRepository repository) {
        this.repository = repository;
    }
}
