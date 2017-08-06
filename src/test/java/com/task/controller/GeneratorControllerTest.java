package com.task.controller;

import com.task.model.Employee;
import com.task.service.GeneratorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dmitriy Lyashenko
 */
@RunWith(SpringRunner.class)
@WebMvcTest(GeneratorController.class)
public class GeneratorControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private GeneratorService generatorService;

    private GeneratorController generatorController;

    private List<Employee> employees = new LinkedList<>();

    @Before
    public void setup(){
        employees.add(new Employee("Den", "Moth", "Developer", "Kiev", 5000));
        employees.add(new Employee("Eva", "Moth", "Manager", "Lvov", 10000));
        employees.add(new Employee("Kolint", "Firth", "Developer", "Kiev", 11100));
        employees.add(new Employee("Sid", "Relop", "Office", "Dnepr", 9000));
        employees.add(new Employee("Lot", "Port", "Manager", "Opo", 5000));
    }

    @Test
    public void getEmployeesBeforePOST() throws Exception {
        //Given
        String jsonContent = "[]";

        //When
        when(generatorService.getCollection()).thenReturn(new LinkedList<Employee>());

        //Then
        String result = mockMvc.perform(get("/employees")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(jsonContent, result);
    }

    @Test
    public void getEmployeesAfterPOST5Capacity() throws Exception {
        //Given
        String jsonContent =
                "[{\"name\":\"Den\",\"surname\":\"Moth\",\"position\":\"Developer\",\"city\":\"Kiev\",\"income\":5000}," +
                "{\"name\":\"Eva\",\"surname\":\"Moth\",\"position\":\"Manager\",\"city\":\"Lvov\",\"income\":10000}," +
                "{\"name\":\"Kolint\",\"surname\":\"Firth\",\"position\":\"Developer\",\"city\":\"Kiev\",\"income\":11100}," +
                "{\"name\":\"Sid\",\"surname\":\"Relop\",\"position\":\"Office\",\"city\":\"Dnepr\",\"income\":9000}," +
                "{\"name\":\"Lot\",\"surname\":\"Port\",\"position\":\"Manager\",\"city\":\"Opo\",\"income\":5000}]";

        //When
        when(generatorService.generate(5)).thenReturn(employees);

        //Then
        String result = mockMvc.perform(post("/employees/5")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(jsonContent, result);
    }

    @Test
    public void getEmployeesFilterAndNotFound() throws Exception {
        //When
        when(generatorService.getCollectionFilterAnd("Joi", null, null, null, null))
                .thenReturn(new LinkedList<Employee>());

        //Then
        String result = mockMvc.perform(get("/employees/filterAnd?name=Joi")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals("[]", result);
    }

    @Test
    public void getEmployeesFilterAndFindOne() throws Exception {
        //Given
        List<Employee> expected = new LinkedList<Employee>();
        expected.add(new Employee("Joi", "Potter", "Developer", "Kiev", 9000));

        //When
        when(generatorService.getCollectionFilterAnd("Joi", null, null, null, null))
                .thenReturn(expected);

        //Then
        String result = mockMvc.perform(get("/employees/filterAnd?name=Joi")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals("[{\"name\":\"Joi\",\"surname\":\"Potter\",\"position\":\"Developer\"," +
                "\"city\":\"Kiev\",\"income\":9000}]", result);
    }

    @Test
    public void getEmployeesFilterAndParametersFail() throws Exception {
        //Given
        List<Employee> expected = new LinkedList<Employee>();
        expected.add(new Employee("Joi", "Potter", "Developer", "Kiev", 9000));

        //When
        when(generatorService.getCollectionFilterAnd("Joi", "Lilo", null, null, null))
                .thenReturn(expected);

        //Then
        String result = mockMvc.perform(get("/employees/filterAnd?name=Joi")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();


        assertEquals("[]", result);
    }


    @Test
    public void getEmployeesFilterOrNotFound() throws Exception {
        //When
        when(generatorService.getCollectionFilterOr("Joi", null, "Developer", null, null))
                .thenReturn(new LinkedList<Employee>());

        //Then
        String result = mockMvc.perform(get("/employees/filterOr?name=Joi&position=Developer")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals("[]", result);
    }

    @Test
    public void getEmployeesFilterOrFindOne() throws Exception {
        //Given
        List<Employee> expected = new LinkedList<Employee>();
        expected.add(new Employee("Joi", "Potter", "Developer", "Kiev", 9000));

        //When
        when(generatorService.getCollectionFilterOr("Joi", null, "Developer", null, null))
                .thenReturn(expected);

        //Then
        String result = mockMvc.perform(get("/employees/filterOr?name=Joi&position=Developer")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals("[{\"name\":\"Joi\",\"surname\":\"Potter\",\"position\":\"Developer\"," +
                "\"city\":\"Kiev\",\"income\":9000}]", result);
    }

    @Test
    public void generateCollectionNonValidEnterParameter() throws Exception {
        //Given
        String expected = "{\"httpStatus\":400," +
                "\"internalErrorCode\":\"3\"," +
                "\"clientMessage\":\"You request is not valid\"," +
                "\"developerMessage\":\"Not valid capacity of expected collection, MIN=1 MAX=7000\"," +
                "\"exceptionMessage\":null," +
                "\"detailErrors\":[]}";

        //When
        String result = mockMvc.perform(post("/employees/10000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();

        //Then
        assertEquals(expected, result);
    }

    @Autowired
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Autowired
    public void setGeneratorController(GeneratorController generatorController) {
        this.generatorController = generatorController;
    }
}