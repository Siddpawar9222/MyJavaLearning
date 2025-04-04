package K_IO_Stream;

import java.util.Scanner;

public class A_Basic {


     public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       System.out.println(a);
       System.err.println();
         
     }
}

/*      
Q)What is System.out.println("Hello World");

 		System.out.println("Hello World");
	--->Class.obj.method(parameter)

-System is class from package java.lang
-out is static field object of PrintStream class which is in System class
-PrintStream class is from package java.io
-println is non static void method of PrintStream class 
-println takes string as as argument and we need to pass string object
For better understanding
	 PrintStream pt = System.out ;
	 pt.println("Siddhesh You are Genius");



Q)What is Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
    --->Class   objRef  =  Call Constructor(Class.obj)

-Scanner is a class in Java to read user input(java.util package). 
-System is class from package java.lang
-in is static field object of InputStream class which is in System class.
-System.in is an instance of InputStream. It represents the standard input stream, which is typically connected to the keyboard. It allows your program to read data that a user types into the console.
*/
