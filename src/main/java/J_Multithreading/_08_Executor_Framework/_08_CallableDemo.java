package J_Multithreading._08_Executor_Framework;

import java.util.concurrent.*;

public class _08_CallableDemo {
    static void main() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Double> callable = ()->{
             Thread.sleep(1000);
             return Math.random();
        };

        Future<Double> future = executorService.submit(callable); // gives future result


        System.out.println("Doing work...");

        Double result = future.get();   // waits for result


        System.out.println("Result = " + result);

        executorService.shutdown();


        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            if (true) {
                throw new Exception("Calculation failed");
            }
            return 100;
        };

        Future<Integer> future1 = executor.submit(task);

        try {
            future1.get();
        } catch (ExecutionException e) {
            System.out.println(e.getCause().getMessage());
        }



    }
}


/*
What is Callable?
Callable is just like Runnable, but better.
Key points:
- It returns a value
- It can throw checked exception
- Used with ExecutorService
Definition
Callable = a task that runs in another thread and gives result back


What is Future?
When you submit a Callable, you get a Future.
Think of Future like:
“I will give you result in future, not now”

Future can:
get result → get()
check done → isDone()
cancel task → cancel()

Why Future.get() blocks?
Integer result = future.get();

If task is still running, main thread waits

This solves:
Thread coordination
Result synchronization

Definition of Future
Future represents the result of an asynchronous computation.
It is a placeholder object that will contain the result of a task in the future.
Future = promise to give result later

* */