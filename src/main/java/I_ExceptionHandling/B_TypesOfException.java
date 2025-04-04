package I_ExceptionHandling;

import java.io.FileReader;

public class B_TypesOfException {
    public static void recursiveMethod() {
        recursiveMethod();
    }

    public static void main(String[] args) {

     //  FileReader fr = new FileReader("test.txt") ; //checked exception
        
        String str = null ;
        System.out.println(str.length());         //uncheched exception

         B_TypesOfException.recursiveMethod();   //Error
    }
}
/*
  Types of Exception : 
  Caused by program
  Can be handle
  1]Checked Exception(compile-time) : 
   the compiler will enforce you to catch these exception
   e.g. IOException, SQLException, etc
    
  2]UnChecked Exception(runtime-time) :
   checked runtime-time, and we are not required to handle or declare them explicitly.
   e.g. ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, etc.
   

  Error : 
  Occurred due to system resources
  Cannot be handle(We must resolve)
  Unchecked
  e.g. NoClassDefFoundError ,StackOverflowError ,OutOfMemoryError etc
  Note : I can handle Error like this 
  try {
		B_TypesOfExceeption.recursiveMethod() ;
		}catch(StackOverflowError e) {
			System.out.println(e);
	}
    But it's generally not recommended to catch or handle Error instances. Errors are usually more severe issues that indicate fundamental problems with the JVM or the runtime environment, and attempting to handle them might not be effective or safe. It's a best practice to focus on preventing errors through proper coding practices and system configuration rather than trying to handle them.

    ClassNotFoundException :
    Type: Checked Exception (subclass of Exception)
     When it occurs:
     This happens when a class is requested at runtime via reflection (Class.forName(), ClassLoader.loadClass(), Thread.getContextClassLoader().loadClass(), etc.), but the JVM cannot find it in the classpath.
     Common Causes:
        The class is missing from the classpath at runtime.
        Incorrect classpath configuration.
        Trying to dynamically load a class that is not present.

     NoClassDefFoundError
     Type: Error (subclass of java.lang.Error)
     When it occurs: This happens when the JVM successfully compiled a class but cannot find it at runtime.
     Common Causes:
         A class was available at compile-time but is missing at runtime.
         Dependency issues, where one class depends on another missing class.
         A class is removed or renamed after compilation.
         Classpath issues after JAR updates.

Note :
Checked exceptions are verified at compile time, meaning the Java compiler forces you to handle them using a try-catch block or declare them in a throws clause.
At compile-time, the compiler does not check whether the class exists in the classpath because:
     The class name is passed as a String to the method.
     The class might be loaded conditionally at runtime.

-Checked exceptions are enforced at compile time, meaning you must handle or declare them.
-ClassNotFoundException occurs at runtime because Java supports dynamic class loading.
-Since Class.forName() takes a String, the compiler does not verify the existence of the class—it only ensures that the exception is handled.

 */