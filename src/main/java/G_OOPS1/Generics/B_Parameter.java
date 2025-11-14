package G_OOPS1.Generics;

import java.util.ArrayList;
import java.util.List;

public class B_Parameter {
    public static void main(String[] args) {
        //Unbounded Type Parameter (<?>)
        List<?> list = new ArrayList<>();
       /*
             This list can hold:
             List<String>
             List<Integer>
             List<Student>
             Anything

        But you cannot add anything into it (because compiler doesn't know the exact type).
        list.add("hello");
       */


        // *************************************************************//


        // Bounded Type Parameter

        /*
         This means you put a boundary (limit) on the type.
         There are two types:
        (A) Upper Bounded (<? extends Something>)
        “Type must be Something OR subtype of Something.”

        */

        List<? extends Number> numbers;

        /*
        This can accept:
            List<Integer>
            List<Double>
            List<Float>
            But NOT:
            List<String>
         */

        //(B) Lower Bounded (<? super Something>)
        //Type must be Something OR supertype of Something.

        List<? super Integer> list1;

        /*
        This can accept:
            List<Integer>
            List<Number>
            List<Object>
            But NOT:
            List<Double>

            Why do we need bounded types?
            1. To ensure type safety

            Example: You want a function that only accepts Number types:
            public void print(List<? extends Number> list) { }

            Now nobody can pass a List<String> by mistake.

            2. To restrict API usage
            Example:
            Upper bound → read only
            Lower bound → write only
         */


    }
}

/*
What is a Type Parameter?
In Java Generics:
class Box<T> { }
T is a type parameter.

It means this class can work with any type:

Box<Integer>
Box<String>
Box<Student>



Note :
Number is a built-in parent class in Java.
It is the superclass for all numeric types


Number
 ├── Integer
 ├── Double
 ├── Long
 ├── Float
 ├── Short
 └── Byte
* */