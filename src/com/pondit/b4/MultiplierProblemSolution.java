package com.pondit.b4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
* A list will contain Maps, empId as key, (importanceValue, listOfSubordinates) as value, which can be considered as a Employee class
* Get the employeeId from the map key, as firstId,
* importanceValue = 0
* pass the map, empId, and importanceValue through the recursive method
* importanceValue += importanceValue;
* pass the map, nextImpId of list and importanceValue through the recursive method
* when all done, return the result
* */

public class MultiplierProblemSolution {
    public static void main(String[] args) {
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(1, 5, List.of(2, 3)));
//        employees.add(new Employee(2, 3, List.of()));
//        employees.add(new Employee(3, 3, List.of()));
//        int id = 1;


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, List.of(2)));
        employees.add(new Employee(2, 3, List.of(3)));
        employees.add(new Employee(3, 3, List.of()));
        int id = 1;

        final Map<Integer, Employee> employeeMap = new HashMap<>();
        employees.forEach(employee -> employeeMap.put(employee.getId(), employee));

        int importanceValue  = 0;
        importanceValue = calculateImportance(employeeMap, id, importanceValue);
        System.out.println("Output: " + importanceValue);
    }

    public static int calculateImportance (Map<Integer, Employee> employeeMap, int nextEmpId, int importanceValue) {
        List<Integer> employees = employeeMap.get(nextEmpId).getEmployees();
        importanceValue = employeeMap.get(nextEmpId).getImportanceValue();
        for (var empId : employees) {
            importanceValue += calculateImportance(employeeMap, empId, importanceValue);
        }
        return importanceValue;
    }
}


class Employee {
    private int id;
    private int importanceValue;
    private List<Integer> employees;

    public Employee(int id, int importanceValue, List<Integer> employees) {
        this.id = id;
        this.importanceValue = importanceValue;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportanceValue() {
        return importanceValue;
    }

    public void setImportanceValue(int importanceValue) {
        this.importanceValue = importanceValue;
    }

    public List<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Integer> employees) {
        this.employees = employees;
    }
}