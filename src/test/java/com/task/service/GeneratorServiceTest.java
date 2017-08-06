package com.task.service;

import com.task.dao.GeneratorRepository;
import com.task.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Dmitriy Lyashenko
 */
@RunWith(SpringRunner.class)
@WebMvcTest(GeneratorService.class)
public class GeneratorServiceTest {

    private GeneratorService generatorService;

    @MockBean
    private GeneratorRepository generatorRepository;

    private List<Employee> employees = new LinkedList<>();

    @Before
    public void setup(){
        employees.add(new Employee("Den", "Moth", "Developer", "Kiev", 5000));
        employees.add(new Employee("Eva", "Moth", "Manager", "Lvov", 10000));
        employees.add(new Employee("Kolin", "Firth", "Developer", "Kiev", 11100));
        employees.add(new Employee("Sid", "Relop", "Office", "Dnepr", 9000));
        employees.add(new Employee("Lot", "Port", "Manager", "Opo", 5000));
    }

    @Test
    public void collectionFilterAnd(){
        //Given
        List<Employee> resultEmployees = new LinkedList<>();
        resultEmployees.add(new Employee("Den", "Moth", "Developer", "Kiev", 5000));

        //When
        Mockito.when(generatorRepository.getCollection()).thenReturn(employees);
        List<Employee> employeesFilter = generatorService
                .getCollectionFilterAnd(null, "Moth", null,  null, 5000);

        //Then
        assertEquals(resultEmployees, employeesFilter);
    }

    @Test
    public void collectionFilterAndOtherTest(){
        //Given
        List<Employee> resultEmployees = new LinkedList<>();
        resultEmployees.add(new Employee("Den", "Moth", "Developer", "Kiev", 5000));
        resultEmployees.add(new Employee("Eva", "Moth", "Manager", "Lvov", 10000));

        //When
        Mockito.when(generatorRepository.getCollection()).thenReturn(employees);
        List<Employee> employeesFilter = generatorService
                .getCollectionFilterAnd(null, "Moth", null,  null, null);

        //Then
        assertEquals(resultEmployees, employeesFilter);
    }

    @Test
    public void collectionFilterAndNoMatches(){
        //Given
        List<Employee> resultEmployees = new LinkedList<>();

        //When
        Mockito.when(generatorRepository.getCollection()).thenReturn(employees);
        List<Employee> employeesFilter = generatorService
                .getCollectionFilterAnd(null, "Harry", null,  null, null);

        //Then
        assertEquals(resultEmployees, employeesFilter);
    }

    @Test
    public void collectionFilterOr(){
        //Given
        List<Employee> resultEmployees = new LinkedList<>();
        resultEmployees.add(new Employee("Den", "Moth", "Developer", "Kiev", 5000));
        resultEmployees.add(new Employee("Kolin", "Firth", "Developer", "Kiev", 11100));
        resultEmployees.add(new Employee("Sid", "Relop", "Office", "Dnepr", 9000));

        //When
        Mockito.when(generatorRepository.getCollection()).thenReturn(employees);
        List<Employee> employeesFilter = generatorService
                .getCollectionFilterOr(null, null, null,  "Kiev", 9000);

        //Then
        assertEquals(resultEmployees, employeesFilter);
    }

    @Test
    public void collectionFilterOrNoMatches(){
        //Given
        List<Employee> resultEmployees = new LinkedList<>();

        //When
        Mockito.when(generatorRepository.getCollection()).thenReturn(employees);
        List<Employee> employeesFilter = generatorService
                .getCollectionFilterOr(null, null, null,  "Sumi", 8000);

        //Then
        assertEquals(resultEmployees, employeesFilter);
    }

    @Test
    public void collectionGet(){
        //When
        Mockito.when(generatorRepository.getCollection()).thenReturn(employees);

        //Then
        assertEquals(employees, generatorService.getCollection());
    }

    @Test
    public void generateCollection(){
        //When
        Mockito.when(generatorRepository.generate(5)).thenReturn(employees);

        //Then
        assertEquals(employees, generatorRepository.generate(5));
    }

    @Autowired
    public void setGeneratorService(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }
}