package com.task.controller;

import com.task.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dmitriy Lyashenko
 */
@RestController
public class GeneratorController {

    private GeneratorService service;

    /**
     * curl -H "Content-type: application/json" -X POST http://localhost:8090/employees/1000
     */
    @PostMapping(value = "/employees/{capacity}", produces = "application/json")
    public ResponseEntity<?> generateCollection(@PathVariable(value = "capacity") Integer capacity){
        return ResponseEntity.ok(service.generate(capacity));
    }

    /**
     * curl -H "Content-type: application/json" -X GET http://localhost:8090/employees
     */
    @GetMapping(value = "/employees", produces = "application/json")
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.ok(service.getCollection());
    }

    @Autowired
    public void setService(GeneratorService service) {
        this.service = service;
    }
}
