package com.task.model;

/**
 * @author Dmitriy Lyashenko
 */
public class Employee {

    private String name;
    private String surname;
    private String position;
    private String city;
    private Integer income;

    public Employee() {
    }

    public Employee(String name, String surname, String position, String city, Integer income) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.city = city;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;
        if (position != null ? !position.equals(employee.position) : employee.position != null) return false;
        if (city != null ? !city.equals(employee.city) : employee.city != null) return false;
        return income != null ? income.equals(employee.income) : employee.income == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (income != null ? income.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", city='" + city + '\'' +
                ", income=" + income +
                '}';
    }
}
