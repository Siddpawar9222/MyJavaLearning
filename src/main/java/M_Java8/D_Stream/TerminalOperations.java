package M_Java8.D_Stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static M_Java8.D_Stream.EmployeeData.employees;

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

      /*
      4. Matching Operations (anyMatch, allMatch, noneMatch) .Takes Predicate
       These methods return true or false based on conditions.

      Example (Industrial Use Case - Checking Employee Salaries)

       anyMatch: Check if any employee has a salary greater than 60000
       allMatch: Check if all employees have a salary greater than 40000
       noneMatch: Check if no employee has a salary of 100000
      * */

        boolean anyHighSalary = employees.stream().anyMatch(emp -> emp.salary > 60000);
        boolean allAbove40k = employees.stream().allMatch(emp -> emp.salary > 40000);
        boolean noneAbove100k = employees.stream().noneMatch(emp -> emp.salary == 100000);

        System.out.println("Any employee with salary > 60000? " + anyHighSalary);
        System.out.println("All employees have salary > 40000? " + allAbove40k);
        System.out.println("No employee has salary 100000? " + noneAbove100k);


        /*
        5. findFirst() & findAny()
           findFirst(): Returns the first element from the stream.
           findAny(): Returns any element (useful in parallel streams).
           Example (Industrial Use Case - Get First Employee with Salary > 50000)
        * */

        Optional<Employee> firstHighSalary = employees.stream()
                .filter(emp -> emp.salary > 50000)
                .findFirst();

        firstHighSalary.ifPresent(emp -> System.out.println("First High Salary Employee: " + emp.name));

        /*
        6. count(Comparator)
        Counts the number of elements in the stream.
        Example (Industrial Use Case - Counting Employees with High Salary)
        * */

        long highSalaryCount = employees.stream()
                .filter(employee -> employee.getSalary() > 20000)
                .count();

        System.out.println(highSalaryCount);


        /*
        7. min() & max()
        min(Comparator): Finds the smallest element.
        max(Comparator): Finds the largest element.
        Example (Industrial Use Case - Find Min & Max Salary Employee)
        * */

        Optional<Employee> minSalaryEmp = employees.stream()
                .min(Comparator.comparing(emp -> emp.salary));

        Optional<Employee> maxSalaryEmp = employees.stream()
                .max(Comparator.comparing(emp -> emp.salary));

        minSalaryEmp.ifPresent(emp -> System.out.println("Employee with Min Salary: " + emp.name));
        maxSalaryEmp.ifPresent(emp -> System.out.println("Employee with Max Salary: " + emp.name));

    }
}
/*
terminal operations consume the stream and produce a result (like a collection, a single value, or a boolean).
*/