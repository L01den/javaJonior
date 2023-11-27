package lesson1.task2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 *    2.1 Создать список из 10-20 сотрудников
 *    2.2 Вывести список всех различных отделов (department) по списку сотрудников
 *    2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 *    2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
 *    2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */

public class Main {
    public static void main(String[] args) {
//        2.1 Создать список из 10-20 сотрудников
        List<Employee> employees = Employee.generateEmploee();

//        2.2 Вывести список всех различных отделов (department) по списку сотрудников
        employees.stream().map(it -> it.getDepartment()).distinct().forEach(System.out::println);
//
////        2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        employees.stream().filter(it -> it.getSalary() <= 10_000).
                map(it -> it.getSalary() * 1.2).forEach(System.out::println);

//        2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> mapDepartment = employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(mapDepartment);

//        2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
//        .mapToInt(a -> a).average().
        Map<String, Double> mapSalary = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(mapSalary);

    }

}

