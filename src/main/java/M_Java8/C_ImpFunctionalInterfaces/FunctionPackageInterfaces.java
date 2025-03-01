package M_Java8.C_ImpFunctionalInterfaces;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionPackageInterfaces {
    public static void main(String[] args) {

        // Predicate : Used for filtering
        Predicate<String> checkIsValid = str-> str.contains("s");
        boolean result = checkIsValid.test("pawar");
        System.out.println(result);

        //Consumer : Used for side effects operation like printing, logging etc.
        Consumer<String> transaction = str-> System.out.println(str);
        //Consumer<String> consumer = System.out::println;
        transaction.accept("MXPRTY");

        //Supplier : useful for lazy evaluation, factories
        Supplier<String> otpGenerator = () -> {
            Random random = new Random();
            return String.format("%06d", random.nextInt(1000000));
        };

        System.out.println("Your OTP is: " + otpGenerator.get());

        // Function : Used for transformation
        Function<Integer, Double> inrToUsd = inr -> inr / 83.0;
        System.out.println(inrToUsd.apply(10000));

      /*
      Other important functional interfaces are

      BiFunction<T, U, R> → Takes two arguments, returns a result.
      BiPredicate<T, U> → Takes two arguments, returns a boolean.
      BiConsumer<T, U> → Takes two arguments, performs an operation.
      UnaryOperator<T> → Takes an argument, returns a value FunctionPackageInterfaces the same type.
      BinaryOperator<T> → Takes two arguments of the same type and returns a value of the same type.
      * */

    }
}
