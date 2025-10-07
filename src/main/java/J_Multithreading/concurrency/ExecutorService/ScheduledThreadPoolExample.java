package J_Multithreading.concurrency.ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Run once after 2 seconds
        scheduler.schedule(() -> {
            System.out.println("One-time task executed by " + Thread.currentThread().getName());
        }, 2, TimeUnit.SECONDS);

        // Run repeatedly every 3 seconds, starting after 1 second
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Repeating task executed by " + Thread.currentThread().getName());
        }, 1, 3, TimeUnit.SECONDS);

        // Run repeatedly with delay of 4 seconds between executions
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Delayed repeating task executed by " + Thread.currentThread().getName());
        }, 1, 4, TimeUnit.SECONDS);
    }
}
