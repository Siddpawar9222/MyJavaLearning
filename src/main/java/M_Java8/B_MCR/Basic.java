// Method and Constructor References

package M_Java8.B_MCR;

@FunctionalInterface
interface YourTask {
    void yourTask();
}

class MyTask {

    public static void myTask() {
        System.out.println("This is my Task......");
    }

    public void mySecondTask() {
        System.out.println("This is second my Task....");
    }
}

public class Basic {
    public static void main(String[] args) {
        
        //Using lambda
        YourTask ytLambda = ()-> System.out.println("Your task");
        ytLambda.yourTask();
        
        //static method
        YourTask yt = MyTask::myTask;
        yt.yourTask();

        //instance methods(Without paramter)
        MyTask mt = new MyTask();
        YourTask yt1 = mt::mySecondTask;
        yt1.yourTask();

    }
}

/*
-Method reference operator :: is used to refer to the methods of functional interface.
-It is compact and easy form of lambda expression.
-Most of the time, we do some operations inside the lambda expression. Sometimes, however, a lambda expression does nothing but call an existing method. In those cases, it’s often clearer to refer to the existing method by name.
-So, whenever you are using a lambda expression to refer to a method, you can also do the same using a method reference. Replace the lambda expression with method reference and it works!
-There are four kinds of method references.
    Reference to static methods.
    Reference to instance methods of particular objects.(Without paramter)
    Reference to an instance method of an arbitrary object of a particular type.(With paramter)
    Reference to a constructor.

 Note :
 paramters of method to be refer must equal to functional interface method paramter.

 In Simple language :
   Method and Constructor References is giving implementation of existing method to functional interface abstract method.
 */