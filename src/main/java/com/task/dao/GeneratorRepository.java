package com.task.dao;

import com.task.model.Employee;
import com.task.util.CollectionGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmitriy Lyashenko
 */
@Repository
public class GeneratorRepository {

    private CollectionGenerator collectionGenerator;

    public List<Employee> generate(Integer capacity) {
        return collectionGenerator.generateCollection(capacity);
    }

    public List<Employee> getCollection() {
        return collectionGenerator.getEmployees();
    }

    @Autowired
    public void setCollectionGenerator(CollectionGenerator collectionGenerator) {
        this.collectionGenerator = collectionGenerator;
    }
}
