package org.example.employee;

import java.util.ArrayList;
import java.util.Arrays;
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

    }

    private static void addEmployeeList(List<Employee> employeeList) {
        System.out.println("Adding Employees in to the list");
        employeeList.add(new Employee(1,"bharath",28,"male", "developer",2018, 2334.44));
        employeeList.add(new Employee(2,"ramesh",39,"male", "tester",2019, 2879.44));
        employeeList.add(new Employee(1,"bharath",29,"male", "developer",2018, 2334.44));
        employeeList.add(new Employee(1,"sushmitha",47,"female", "developer",2006, 23348.44));
    }
}
