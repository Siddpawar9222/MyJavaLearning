package G_OOPS.Polymorphism;

/*
If a class has multiple methods having same name but different in parameters, it is known as Method Overloading.

Advantage of method overloading
Method overloading increases the readability of the program.

There are three ways to overload the method in java
   By changing numbers of parameters
   By changing the data type
   Sequence of data-type of parameter

Suppose you have to perform addition of the given numbers but there can be any number of arguments, if you write the method such as a(int,int) for two parameters, and b(int,int,int) for three parameters then it may be difficult for you as well as other programmers to understand the behavior of the method because its name differs.

So, we perform method overloading to figure out the program quickly

IMP//In Java, Method Overloading is not possible by changing the return type of the method only.

compiler time polymorphism
*/
public class MethodOverloading {

	static int plusMethod(int x, int y) {
		return x + y;
	}

	static double plusMethod(double x, double y) {
		return x + y;
	}

	static double plusMethod(double x, double y, double z) {
		return x + y;
	}

	static void plusMethod(int a, int b, int c) {
		System.out.println(a + b + c);
	}

//    static int plusMethod(int a , int b , int c) {
//    	return a+b+c ;
//    }                          //It is not possible by changing the return type of the method only.         

	public static void main(String[] args) {
		int myNum1 = plusMethod(8, 5);
		double myNum2 = plusMethod(4.3, 6.26);
		double myNum3 = plusMethod(4.5, 4.6, 4.7);

		System.out.println("int: " + myNum1);
		System.out.println("double: " + myNum2);
		System.out.println("double1 " + myNum3);
		plusMethod(4, 5, 6);

	}

}
