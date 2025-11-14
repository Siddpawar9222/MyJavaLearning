package G_OOPS1.Generics;

import java.util.ArrayList;
import java.util.List;

public class D_PECE {
    public static void main(String[] args) {

        // ************************ PECS RULE ************************ //
        /*
            PECS → Producer Extends, Consumer Super

            Meaning:
            -----------------------------------------------------------
            1. If your code PRODUCES (returns/reads) values → use ? extends T
            2. If your code CONSUMES (adds/inserts) values → use ? super T
        */

        // ************************************************************* //

        // Producer = ? extends T (READ ONLY)
        /*
            Use ? extends T when:
                - You want to READ values from the list
                - The list is producing values for you
                - You DON’T add values into the list

            Example:
                List<? extends Number> nums;

            This can accept:
                List<Integer>
                List<Double>
                List<Float>

            Why read only?
                Because the compiler doesn't know the exact subtype.
                You can only safely treat elements as Number.

            nums.get(0);   // ✔ allowed (as Number)
            nums.add(10);  // ❌ not allowed
        */

        // ************************************************************* //

        // Consumer = ? super T (WRITE ONLY)
        /*
            Use ? super T when:
                - You want to ADD items to the list
                - The list is consuming values from you
                - Reading returns Object (not exact type)

            Example:
                List<? super Integer> list;

            This can accept:
                List<Integer>
                List<Number>
                List<Object>

            Why write allowed?
                Because all these can store Integer safely.

            list.add(10);   // ✔ allowed
            list.get(0);    // ✔ allowed but returns Object
        */

        // ************************************************************* //

        // Unbounded Type (<?>)
        /*
            Use <?> when:
                - You want to accept any type
                - You only need to READ as Object
                - You don’t need add access

            Example:
                List<?> list;

            This can accept:
                List<String>
                List<Integer>
                List<Student>

            list.get(0);    // ✔ allowed (Object)
            list.add("Hi"); // ❌ not allowed (type unknown)
        */

        // ************************************************************* //

        // Quick Summary (Easy to Remember)
        /*
                ? extends T  → Producer  → Only get (READ)
                ? super T    → Consumer  → Only put (WRITE)
                ?            → Unknown   → Only read as Object
         */

        // ************************************************************* //
        // ***************  PRACTICAL JAVA EXAMPLES  ****************** //
        // ************************************************************* //

        // ******** Example 1: Producer (extends) ******** //
        /*
            Goal:
                Calculate sum of any numeric list.
                We only READ values → so use ? extends Number
         */
        System.out.println(sumOfNumbers(List.of(10, 20, 30)));       // Integer list
        System.out.println(sumOfNumbers(List.of(1.5, 2.5, 3.5)));    // Double list


        // ******** Example 2: Consumer (super) ******** //
        /*
            Goal:
                Add integers into a list safely.
                We only WRITE into the list → so use ? super Integer
         */
        List<Number> numList = new ArrayList<>();
        addIntegers(numList);

        System.out.println(numList); // Output: [100, 200, 300]
    }


    // Example 1 → PRODUCER (extends)
    public static double sumOfNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();   // safe read
        }
        return sum;
    }

    // Example 2 → CONSUMER (super)
    public static void addIntegers(List<? super Integer> list) {
        list.add(100);   // safe add
        list.add(200);
        list.add(300);
    }
}
