package M_Java8.D_Stream.New;

import java.util.List;

public class EmployeeData {
   static List<Employee>  employees = List.of(
            new Employee("Siddhesh", 45222),
            new Employee("Santosh", 50222),
            new Employee("manisha", 41222),
            new Employee("ram", 30422),
            new Employee("karan", 6322),
            new Employee("sweta", 786112)
    );

    static List<Employee> employeesWithSkills = List.of(
            new Employee("Siddhesh", List.of("java", "react")),
            new Employee("Santosh", List.of("python", "angular")),
            new Employee("manisha", List.of("testing")),
            new Employee("ram", List.of("data science"))
    );
}
