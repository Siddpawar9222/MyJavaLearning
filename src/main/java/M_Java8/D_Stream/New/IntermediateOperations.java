package M_Java8.D_Stream.New;

import java.util.Comparator;
import java.util.List;

import static M_Java8.D_Stream.New.EmployeeData.employees;
import static M_Java8.D_Stream.New.EmployeeData.employeesWithSkills;

public class IntermediateOperations {
    public static void main(String[] args) {

        /*
         1. Filtering (filter(Predicate))
         Used for : Removing unwanted elements from the stream.
         */
        List<Employee> filteredList = employees.stream()
                .filter(employee -> employee.getSalary() > 40000)
                .toList();

        System.out.println(filteredList);

        /*
        2. Mapping (map(Function))
        Used for: Transforming elements from one type to another.
        */

        List<String> employeesName = employees.stream()
                .map(Employee::getName)
                .toList();
        System.out.println(employeesName);

        /*
        3. FlatMapping (flatMap(Function))
        Used for: Flattening nested collections (List of Lists).
        */
        List<String> employeesSkills = employeesWithSkills.stream()
                .flatMap(employee -> employee.getSkills().stream())
                .toList();

        System.out.println(employeesSkills);

        /*
        4. Sorting (sorted() and sorted(Comparator))
        Used for : Sorting
        */
        List<Employee> sortedEmployeeList = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();

        System.out.println(sortedEmployeeList);

       /*
       5. Distinct elements (distinct())
       Used for: Removing duplicate elements.
       */
        List<String> categories = List.of("Electronics", "Clothing", "Electronics", "Books");

        List<String> uniqueCategories = categories.stream()
                .distinct()
                .toList();

        System.out.println(uniqueCategories);


        /*
         6. Limiting and Skipping (limit(long) & skip(long))
             Used for:
                     limit(n): Get only the first n elements.
                     skip(n): Skip the first n elements and get the rest.
        * */
        List<Employee> top2 = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // Sort descending
                .limit(2)
                .toList();

        System.out.println(top2);

        List<Employee> remainingAllExceptTop2 = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // Sort descending
                .skip(2)
                .toList();

        System.out.println(remainingAllExceptTop2);



        /*
        7. Peeking (peek(Consumer))
           Used for: Debugging or logging data while processing.

        * */
        List<Employee> filteredListWithPeek = employees.stream()
                .peek(employee -> System.out.println("Employee " + employee))
                .filter(employee -> employee.getSalary() > 40000)
                .toList();

        System.out.println(filteredListWithPeek);


    }
}
/*
Intermediate operations are lazy operations that transform a stream into another stream. They don’t execute immediately—they only run when a terminal operation (like collect(), forEach(), count()) is applied.
* */