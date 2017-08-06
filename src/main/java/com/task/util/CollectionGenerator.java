package com.task.util;

import com.task.loader.CityLoader;
import com.task.loader.NameLoader;
import com.task.loader.PositionLoader;
import com.task.loader.SurnameLoader;
import com.task.model.Employee;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Dmitriy Lyashenko
 */
@Component
public class CollectionGenerator {

    private int capacity;
    private int manCount;
    private int womanCount;

    private List<Employee> employees = new LinkedList<>();

    private final NameLoader nameLoader = new NameLoader();
    private final SurnameLoader surnameLoader = new SurnameLoader();
    private final CityLoader cityLoader = new CityLoader();
    private final PositionLoader positionLoader = new PositionLoader();

    public List<Employee> generateCollection(Integer capacity){
        this.capacity = capacity;
        manWomanCount(capacity);
        generate();
        return getEmployees();
    }

    private void manWomanCount(Integer capacity){
        Random random = new Random();
        if (capacity == 1) {
            if (random.nextBoolean()) {
                manCount = 1;
                womanCount = 0;
            } else {
                womanCount = 1;
                manCount = 0;
            }
        } else {
            womanCount = capacity / 2 - (capacity / 2) / 5;
            manCount = capacity - womanCount;
        }
    }

    private void generate() {
        List<Employee> man = new LinkedList<>();
        if (manCount > 0){
            manEmployeesCreator(man, manCount, nameLoader.getManNames(), surnameLoader.getManEnding());
        }

        List<Employee> woman = new LinkedList<>();
        if (womanCount > 0) {
            womanEmployeesCreator(woman, womanCount, nameLoader.getWomanNames(), surnameLoader.getWomanEnding());
        }

        employees = new LinkedList<>();
        employees.addAll(man);
        employees.addAll(woman);
    }

    private void manEmployeesCreator(List<Employee> man, int count, String[] names, String[] surnames) {
        for (int i = 0; i < count; i++){
            Employee manEmployee = createEmployee(names, surnames);
            man.add(manEmployee);
        }

        Set<Employee> employeeSet = new TreeSet<>(man);

        if (employeeSet.size() != manCount){
            man.clear();
            man.addAll(employeeSet);
            manEmployeesCreator(man, manCount - employeeSet.size(), names, surnames);
        }
    }

    private void womanEmployeesCreator(List<Employee> woman, int count, String[] names, String[] surnames) {
        for (int i = 0; i < count; i++){
            Employee womanEmployee = createEmployee(names, surnames);
            woman.add(womanEmployee);
        }

        Set<Employee> employeeSet = new TreeSet<>(woman);

        if (employeeSet.size() != womanCount){
            woman.clear();
            woman.addAll(employeeSet);
            womanEmployeesCreator(woman, womanCount - employeeSet.size(), names, surnames);
        }
    }

    private Employee createEmployee(String[] names, String[] surnames) {
        String name = names[new Random().nextInt(names.length)];
        String surname = createSurname(names[new Random().nextInt(names.length)], surnames[new Random().nextInt(surnames.length)]);
        String position = positionLoader.getPositions()[new Random().nextInt(positionLoader.getPositionsCount() + 1)];
        String city = cityLoader.getCities()[new Random().nextInt(cityLoader.getCitiesCount() + 1)];
        int randomInt = new Random().nextInt(15000) + 1;
        Integer income = randomInt < 5000 ? randomInt + 5000 : randomInt;

        return new Employee(name, surname, position, city, income);
    }

    private String createSurname(String name, String surnameEnding) {
        if (name.endsWith("ей") || name.endsWith("ий")) {
            if (surnameEnding.equals("цкий")
                || surnameEnding.equals("кин")
                || surnameEnding.equals("ев")
                || surnameEnding.equals("цов")
                || surnameEnding.equals("цев")
                || surnameEnding.equals("евцев")
                || surnameEnding.equals("ец")
                || surnameEnding.equals("енко")
                || surnameEnding.equals("енков")){
                return name.substring(0, name.length() - 1) + surnameEnding;
            } else if (surnameEnding.equals("ский")) {
                return name + surnameEnding;
            } else {
                return name.substring(0, name.length() - 2) + surnameEnding;
            }
        }

        if (name.endsWith("а") || name.endsWith("я")) {
            if (surnameEnding.equals("цкий")
                || surnameEnding.equals("ев")
                || surnameEnding.equals("евцев")){
                return name + surnameEnding;
            } else {
                return name.substring(0, name.length() - 1) + surnameEnding;
            }
        }

        return name + surnameEnding;
    }

    @Scheduled(cron = "59 0/59 * * * *")
    private void onSchedule() {
        if (capacity != 0){
            generate();
        }
    }

    public int getManCount() {
        return manCount;
    }

    public int getWomanCount() {
        return womanCount;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
