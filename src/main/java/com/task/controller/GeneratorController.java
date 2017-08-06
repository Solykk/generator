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
@Validated
@RequestMapping(value = "/employees")
public class GeneratorController {

    private GeneratorService service;

    /**
     * Этот метод устанавливает количество генерируемых объектов и возвращает сгенерированную коллекцию.
     * Минимальный размер коллекции 1, максимальный 7000.
     * Пример curl запроса:
     * curl -H "Content-type: application/json" -X POST http://localhost:8090/employees/1000
     */

    @PostMapping(value = "/{capacity}", produces = "application/json")
    public ResponseEntity<?> generateCollection(@Min(value = 1)
                                                @Max(value = 7000)
                                                @PathVariable(value = "capacity") Integer capacity){
        return ResponseEntity.ok(service.generate(capacity));
    }

    /**
     * Этот метод возвращает сгенерированную коллекцию либо пустую коллекцию, если не установлено количество
     * генерируемых объектов.
     * Пример запроса:
     * http://localhost:8090/employees
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.ok(service.getCollection());
    }

    /**
     * Этот метод возвращает отфильтрованную коллекцию которая содержит объекты соответствующие
     * всем входящим параметрам.
     * Количество и порядок параметров значения не имеет.
     * Пример запроса:
     * http://localhost:8090/employees/filterAnd?name=Иван&surname=Петров&position=Инженер&city=Киев&income=5900
     */
    @GetMapping(value = "/filterAnd", produces = "application/json")
    public ResponseEntity<?> getEmployeesFilterAnd(@RequestParam(value = "name", required = false) String name,
                                                @RequestParam(value = "surname", required = false) String surname,
                                                @RequestParam(value = "position", required = false) String position,
                                                @RequestParam(value = "city", required = false) String city,
                                                @RequestParam(value = "income", required = false) Integer income){

        return ResponseEntity.ok(service.getCollectionFilterAnd(name, surname, position, city, income));
    }

    /**
     * Этот метод возвращает отфильтрованную коллекцию которая содержит объекты соответствующие
     * любому из входящих параметров.
     * Количество и порядок параметров значения не имеет.
     * Пример запроса:
     * http://localhost:8090/employees/filterOr?city=Киев&income=6455
     */
    @GetMapping(value = "/filterOr", produces = "application/json")
    public ResponseEntity<?> getEmployeesFilterOr(@RequestParam(value = "name", required = false) String name,
                                                @RequestParam(value = "surname", required = false) String surname,
                                                @RequestParam(value = "position", required = false) String position,
                                                @RequestParam(value = "city", required = false) String city,
                                                @RequestParam(value = "income", required = false) Integer income){

        return ResponseEntity.ok(service.getCollectionFilterOr(name, surname, position, city, income));
    }

    @Autowired
    public void setService(GeneratorService service) {
        this.service = service;
    }
}
