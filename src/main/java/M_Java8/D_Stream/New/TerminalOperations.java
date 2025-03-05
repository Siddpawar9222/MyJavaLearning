package M_Java8.D_Stream.New;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static M_Java8.D_Stream.New.EmployeeData.employees;

public class TerminalOperations {
    public static void main(String[] args) {
         /*
         1. forEach(Consumer)
         Iterate through each element of the stream and perform an action.
         */
        employees.stream()
                .forEach(employee -> System.out.println("Salary hike amount for employee " + employee.getName() + " is " + employee.getSalary() * 1.5));

         /*
          2. collect(Collector)
          convert a stream into a List, Set, Map, or String
         */

        // Collect names into a List
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

       // Collect names into a Set
        Set<String> uniqueNames = employees.stream()
                .map(emp -> emp.name)
                .collect(Collectors.toSet());

        // Collect names as a comma-separated string
        String namesJoined = employees.stream()
                .map(emp -> emp.name)
                .collect(Collectors.joining(", "));


        System.out.println("Employee Names List: " + employeeNames);
        System.out.println("Unique Names Set: " + uniqueNames);
        System.out.println("Names Joined: " + namesJoined);


        /*
         3. reduce(identity, accumulator)
         reduces the stream to a single value, such as sum, max, or concatenation etc.
        * */
        Integer salarySum = employees.stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
        System.out.println(salarySum);
    }
}
/*
terminal operations consume the stream and produce a result (like a collection, a single value, or a boolean).
*/