package I_ExceptionHandling;

public class E_ExceptionInfoFuctions {

	public static void main(String[] args) {
        try {
            int num = 10 / 0;
        }catch (ArithmeticException e) {
            
            System.out.println("getMessage message: " + e.getMessage());
            System.out.println("toString message: " + e.toString());
            e.printStackTrace();
       }
    }

}
/*
printStackTrace():
This void method prints exception information in the format of Name of the exception:description of the exception, stacktrace.
//toString():
This method prints exception information in the format of Name of the exception: description of the exception.
getMessage():
This method prints only the description of the exception.
 */
