package org.example.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeMain {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        // Add EmployeeList
        addEmployeeList(employeeList);


        System.out.println("group based on the genders");
        employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("group by multiple fields");
        Function<Employee,List<Object>> groupBy  = e-> Arrays.asList(e.getGender(),e.getPosition());

        employeeList.stream()
                .collect(Collectors.groupingBy(groupBy)).entrySet().forEach(System.out::println);

        System.out.println("print all the department names in the organization");
        employeeList.stream()
                .map(Employee::getPosition)
                .distinct()
                .forEach(System.out::println);

        System.out.println("Get the details of highest paid employee in the organization");
        employeeList
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        System.out.println("Find all the employee whose joined after 2015");
        employeeList
                .stream()
                .filter(e->e.getYoj()>2015)
                .collect(Collectors.toList())
                .stream()
                .forEach(System.out::println);

        System.out.println("Group based on the gender and find the number of employees");
        employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("Find the average salary of the each position");
        employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getPosition, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("Youngest male in the developer position");
        employeeList.stream()
                .filter(e->e.getPosition().equalsIgnoreCase("developer"))
                .min(Comparator.comparing(Employee::getAge))
                .ifPresent(System.out::println);


        System.out.println("Who as the most experience in the work");
        String name = employeeList.stream()
                .min(Comparator.comparing(Employee::getYoj))
                .get().getName();
        System.out.println("Most Experienced employee ::"+name);


        System.out.println("Get key as an ID and name in the value in map");
        employeeList.stream().collect(Collectors.toMap(Employee::getId,Employee::getName)).entrySet().forEach(System.out::println);

    }


    private static void addEmployeeList(List<Employee> employeeList) {
        System.out.println("Adding Employees in to the list");
        employeeList.add(new Employee(1,"bharath",28,"male", "developer",2018, 2334.44));
        employeeList.add(new Employee(2,"ramesh",39,"male", "tester",2019, 2879.44));
        employeeList.add(new Employee(4,"bharath",29,"male", "developer",2018, 2334.44));
        employeeList.add(new Employee(3,"sushmitha",47,"female", "developer",2006, 23348.44));
    }
}
