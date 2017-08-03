package com.task.controller;

import com.task.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Dmitriy Lyashenko
 */
@RestController
@RequestMapping(value = "/employees")
public class GeneratorController {

    private GeneratorService service;

    /**
     * curl -H "Content-type: application/json" -X POST http://localhost:8090/employees/1000
     */
    @Validated
    @PostMapping(value = "/{capacity}", produces = "application/json")
    public ResponseEntity<?> generateCollection(@Min(value = 1)
                                                @Max(value = 10000)
                                                @PathVariable(value = "capacity") Integer capacity){
        return ResponseEntity.ok(service.generate(capacity));
    }

    /**
     * curl -H "Content-type: application/json" -X GET http://localhost:8090/employees
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.ok(service.getCollection());
    }

    @Autowired
    public void setService(GeneratorService service) {
        this.service = service;
    }
}
