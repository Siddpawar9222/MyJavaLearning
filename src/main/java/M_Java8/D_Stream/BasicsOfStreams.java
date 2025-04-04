package M_Java8.D_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static M_Java8.D_Stream.EmployeeData.employees;

public class BasicsOfStreams {

    public static void main(String[] args) {
        // Create Stream from list and set using stream method
        employees.stream()
                .filter(str->str.getName().startsWith("S"))
                .forEach(System.out::println);

        // Create Stream from Arrays
        Employee[] employeesArray = {
                new Employee("John",45222) ,
                new Employee("Jasmine",50242) ,
                new Employee("carry",41223) ,
                new Employee("natalia",96322)
        };

        Arrays.stream(employeesArray)
                .filter(employee -> employee.getSalary()%2==0)
                .forEach(System.out::println);


        // Using Stream.of() : stream from individual values. Calls Arrays.stream internally
        Stream<Employee> employeeStream = Stream.of(new Employee("Alice", 51222),
                new Employee("Blob", 78121));


        //Infinite Streams using  Stream.generate() and Stream.iterate()

        Stream.generate(()->{
                    Random random = new Random();
                    return String.format("%06d", random.nextInt(1000000));
                })
                .limit(5)
                .forEach(System.out::println);

        Stream.iterate(1001, n -> n + 1) // Start from 1001, increase by 1
                .limit(5)
                .forEach(System.out::println);


        /*
         Types of streams
            A]Sequential Streams (Default) :
               Sequential streams process elements one by one.
               already seen this

            B]Parallel Streams :
               Parallel streams split tasks across multiple CPU cores for faster execution.
        */

        List<String> orders = Arrays.asList("Order-1", "Order-2", "Order-3");

        orders.parallelStream() // Parallel Stream
                .forEach(order -> System.out.println("Processing " + order + " by " + Thread.currentThread().getName()));
    }
}
