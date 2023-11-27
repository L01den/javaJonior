package lesson1.task2;
//      2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department

import java.util.List;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

//    2.1 Создать список из 10-20 сотрудников
    public static List<Employee> generateEmploee(){
        List<Employee> employees = List.of(
                new Employee("Oleg", 27, 10000, "Отдел продаж"),
                new Employee("Nastia", 40, 30000, "Отдел продаж"),
                new Employee("Sahsa", 32, 15000, "Отдел продаж"),

                new Employee("Anna", 34, 40000, "Менеджер"),
                new Employee("Nikita", 29, 23000, "Менеджер"),
                new Employee("Kolia", 50, 10000, "Менеджер"),

                new Employee("Marina", 38, 10000, "Бухгалтер"),
                new Employee("Katia", 43, 12000, "Бухгалтер"),

                new Employee("Igor", 24, 10000, "Курьер"),
                new Employee("Slava", 26, 15000, "Курьер"),

                new Employee("Kira", 29, 55000, "Программист"),
                new Employee("Kiril", 31, 50000, "Программист"),
                new Employee("Dasha", 26, 60000, "Программист"),
                new Employee("Misha", 34, 53000, "Программист"),

                new Employee("Olga", 35, 70000, "Генеральный директор"),
                new Employee("Vlad", 40, 80000, "Директор")
                );
        return employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name - " + name;
    }
}
