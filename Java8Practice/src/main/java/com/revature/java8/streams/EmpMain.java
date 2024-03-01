package com.revature.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmpMain {
    public static void main(String[] args) {
        List<Employee> emp = Arrays.asList( new Employee(1,"Raagul",5000.0),
                                            new Employee(2,"Gopi",6500.0),
                                            new Employee(3,"Vishnu",4500.0));

        List<String> names = emp.stream().map(Employee::getName).sorted().toList();
        names.forEach(System.out::println);
        System.out.println("=======================");
        names.stream().filter(name->name.contains("i")).forEach(System.out::println);

        System.out.println("-----------------------");

        List<Double> salary = emp.stream().map(Employee::getSalary).sorted().collect(Collectors.toList());
        salary.forEach(System.out::println);
    }
}
