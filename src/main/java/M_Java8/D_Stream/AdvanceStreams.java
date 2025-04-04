package M_Java8.D_Stream;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static M_Java8.D_Stream.EmployeeData.employeesWithId;

public class AdvanceStreams {
    static class Student {
        String name;
        String grade;

        public Student() {
        }

        public Student(String name, String grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", grade='" + grade + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        /*
        toMap() → Collects elements into a Map (Key-Value pair)
         Important: If duplicate keys exist, you will get an error. Use (oldValue, newValue) -> oldValue to handle duplicates.
        * */

        Map<Integer, String> idToNameMap = employeesWithId.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));

        System.out.println(idToNameMap);

        List<Student> students = List.of(
                new Student("Alice", "A"),
                new Student("Bob", "B"),
                new Student("Charlie", "A"),
                new Student("Bobby", "B")
        );

       /*
       * groupingBy() → Groups data by a specific condition (like SQL GROUP BY)
       * */
        Map<String, List<Student>> groupByGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        System.out.println(groupByGrade);

       /*
       * partitioningBy() → Divides data into two groups (true/false condition)
       * */
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> evenOddPartition = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println(evenOddPartition);

        /*
       Downstream collectors are used inside groupingBy() to perform extra operations.
       Example: Counting even and odd numbers
        * */
        Map<Boolean, Long> evenOddPartitionCounting = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0, Collectors.counting()));

        System.out.println(evenOddPartitionCounting);

        /*
         Joining Strings using Collectors.joining()
        Used to join multiple strings into one single string.
        Example: Joining a list of names into one string.
        * */

        List<String> names = List.of("Alice", "Bob", "Charlie");
        String joinedNames = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joinedNames);


        String formattedNames = names.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(formattedNames);


        /*
        * Join two streams
        * Stream.concat
        * */

        List<String> teamA = List.of("Alice", "Bob");
        List<String> teamB = List.of("Carlie","Bobby");

        Stream<String> concatedStream = Stream.concat(teamA.stream(), teamB.stream());

        concatedStream.forEach(cs-> System.out.print(cs + " "));

        System.out.println();


        /*
        * Exception Handling
        * */

        try (InputStream inputStream = AdvanceStreams.class.getClassLoader().getResourceAsStream("products.txt")) {
            if (inputStream == null) {
                System.out.println("File not found!");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                Stream<String> lines = reader.lines();
                lines.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }
}

/*
 Advance Streams
   .collect parameters
     Collectors.toList()
     Collectors.toSet()
     Collectors.toMap()
     Collectors.groupingBy()
     Collectors.partitioningBy()
     Collectors.joining()
* */