package M_Java8.A_LambdaExp;

public class Basic {
       
}

/*
Ways to provide implementation for functional interface :
 1. Simple create class and implement functional interface
 2. Anonymous expression (or class)
 3. Lambda expression

Lambda expression provides implementation for(only works for) functional interface.


-A lambda expression, also known as a lambda function or anonymous function, is a feature introduced in Java 8 that allows you to treat a block of code as a method argument.
-lambda expression has no name , no access modifier and no return type.

Advantages :
  -Reduce line of code and make code more readable , maintainable and concise .
  -Enable functional programming which helps to sequential and parallel execution supported by passing  behaviour as an argument.(Learn about it)
  ( What is Functional programming : We can use  function as entity and we can pass function to another function as argument)
  -To call APIs very effectively.

Rules :
 -If body of Lambda expression contain only one statement then curly braces are optional
 -Type(data type) of parameter optional.
*/