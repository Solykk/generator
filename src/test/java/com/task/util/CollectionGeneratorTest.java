package com.task.util;

import com.task.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Dmitriy Lyashenko
 */
public class CollectionGeneratorTest {

    private CollectionGenerator collectionGenerator;

    @Before
    public void setup(){
        collectionGenerator = new CollectionGenerator();
    }

    @Test
    public void collectionIsEmptyAfterStart(){
        //When
        CollectionGenerator collection = new CollectionGenerator();

        //Then
        assertTrue(collection.getEmployees().isEmpty());
    }

    @Test
    public void generateCollectionWithTenElementsAnd60on40ManOnWoman(){
        //Given
        List<Employee> employeeList = collectionGenerator.generateCollection(10);

        //Then
        assertEquals(10, employeeList.size());
        assertEquals(6, collectionGenerator.getManCount());
        assertEquals(4, collectionGenerator.getWomanCount());
    }

    @Test
    public void uniqueCollection(){
        //Given
        List<Employee> employeeList = collectionGenerator.generateCollection(100);

        //When
        Set<Employee> employeeSet = new LinkedHashSet<>(employeeList);

        //Then
        assertEquals(employeeSet.size(), employeeList.size());
    }

    @Test
    public void uniqueCollectionSurname(){
        //Given
        List<Employee> employeeList = collectionGenerator.generateCollection(100);

        //When
        Set<Employee> employeeSet = new TreeSet<>(employeeList);

        //Then
        assertEquals(employeeSet.size(), employeeList.size());
    }
}