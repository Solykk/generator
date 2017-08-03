package com.task.dao;

import com.task.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Dmitriy Lyashenko
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorRepositoryTest {

    private GeneratorRepository generatorRepository;

    @Test
    public void collectionAfterFirstPOST(){
        //When
        List<Employee> employees = generatorRepository.generate(10);

        //Then
        assertEquals( 10, employees.size());
    }

    @Test
    public void collectionAfterFirstPOSTAndFirstGET(){
        //When
        List<Employee> employees = generatorRepository.generate(10);
        List<Employee> employeesGet = generatorRepository.getCollection();

        //Then
        assertEquals( employeesGet, employees);
    }

    @Autowired
    public void setGeneratorRepository(GeneratorRepository generatorRepository) {
        this.generatorRepository = generatorRepository;
    }
}