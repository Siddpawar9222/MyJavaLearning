package J_Multithreading.concurrency._05Collable;

public class _01_Problem implements  Runnable {
    @Override
    public void run(){       // Only void return
        int result = 45 + 45 ;
        //throw  new Exception("Checked Exception");  // cannot throws checked exception
    }
}

/*
Problem with Runnable
Before Callable, we mostly used Runnable.
Runnable limitations
- Cannot return a result
- Cannot throw checked exception
* */