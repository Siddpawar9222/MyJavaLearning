package M_Java8.D_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class SpecializedStreams {
    public static void main(String[] args) {

        /*
        Create Stream of primitive data types
        * */


      /*
        1. Using range() and rangeClosed()
        These methods generate a range of numbers.

        range(start, end) → Excludes end
        rangeClosed(start, end) → Includes end
      * */

        IntStream.range(1 ,20)
                .forEach(System.out::println);


         /*
          Using mapToInt(), mapToDouble()
          These methods convert object streams to primitive streams.
         * */

        List<Double> sales = Arrays.asList(1200.5, 2500.75, 3100.0, 1450.25);
        sales.stream()
                .mapToDouble(Double::doubleValue)
                .forEach(System.out::println);

        /*
        Operations on Primitive Streams
        * */

        /*
         1. sum()
         Finds the sum of all elements.
        * */

        int totalSalary = IntStream.of(50000, 60000, 75000, 90000)
                .sum();

        System.out.println("Total Salary Expense: $" + totalSalary);


        /*
        2. average()
        Finds the average value.
        * */

        OptionalDouble avgRating = IntStream.of(5, 4, 3, 5, 4, 5)
                .average();

        if(avgRating.isPresent()){
            System.out.println("Average Rating: " + avgRating.getAsDouble());
        }else{
            System.out.println("No Rating");
        }


        /*
        * Convert primitive to object using boxed
        * */
        int[] nums = {1, 1, 2, 2, 3};

        //primitives to object

        Integer[] arr =   Arrays.stream(nums).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));

        //object to primitives
        int[] primitiveArray = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }
}
/*
Java provides specialized versions of streams for primitive data types to improve performance. The regular Stream<T> works with objects (like Stream<Integer>), but primitive streams avoid unnecessary boxing/unboxing.

There are three specialized streams:

IntStream → Works with int values
LongStream → Works with long values
DoubleStream → Works with double values
* */