package J_Multithreading.concurrency._06CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo {
    static void main() throws ExecutionException, InterruptedException {
//        CompletableFuture<String> greetingFuture = CompletableFuture.supplyAsync(() -> {
//            return "Hello from CompletableFuture";
//        });
//
//        System.out.println("Result " + greetingFuture.get());
//        System.out.println("Main Method Ended.....");

        CompletableFuture<Void> future =
                CompletableFuture.runAsync(() -> {
                    System.out.println("Task running in thread: " + Thread.currentThread().getName());
                });
        future.join();
        System.out.println("Main thread finished");


//                CompletableFuture.runAsync(() -> {
//                    System.out.println("Task running in thread: " + Thread.currentThread().getName());
//
//                    try {
//                        Thread.sleep(2000); // simulate work
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println("Async task finished");
//                });

                CompletableFuture.supplyAsync(()->{
                       return  "Hello " ;
                }).thenAccept((result)->{
                    System.out.println(result + " World");
                });
        System.out.println("Main thread finished");

    }
}
/*
Using CompletableFuture we can run task in background(async) as well as we can wait for result for given task(sync)
CompletableFuture.supplyAsync(Supplier) : return the task result
CompletableFuture.runAsync(Runnable runnable) : return void
Note :
the task is started immediately, even when you store it in a reference variable or not.

get() and join() :
Both are used to wait for CompletableFuture to finish and return the result.
get() : throws InterruptedException, ExecutionException , so need to handle exception
join() :  doesnt throw exception

Chaining Methods:
thenApply() → transform data
thenAccept() → consume data
thenRun() → run next task
thenCompose() → async dependency
thenCombine() → parallel tasks
* */