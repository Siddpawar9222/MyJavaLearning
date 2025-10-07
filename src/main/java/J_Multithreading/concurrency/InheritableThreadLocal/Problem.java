package J_Multithreading.concurrency.InheritableThreadLocal;

public class Problem {
    private static final ThreadLocal<String> userContext  = new ThreadLocal<>() ;
    public static void main(String[] args) {
         userContext.set("Parent Thread");   //current thread

        Runnable runnable = ()->{
            System.out.println("Child thread: " + userContext.get());
        };

        Thread thread = new Thread(runnable,"Child Thread") ;
        thread.start();
    }
}
/*
Problem with ThreadLocal :
When we use ThreadLocal, the data is only available in the current thread.
If that thread creates a child thread, the child thread does not inherit the parent’s ThreadLocal value.
* */