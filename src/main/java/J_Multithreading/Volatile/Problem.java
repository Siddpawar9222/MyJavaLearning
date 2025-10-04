package J_Multithreading.Volatile;

public class Problem {
    private static boolean flag = false;  // Not volatile → visibility issue!
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        // Thread 1: Waits for flag to become true
        Thread thread1 = new Thread(() -> {
            while (!flag) {
                // Busy wait
                //System.out.println("Thread 1: Waiting for flag to become TRUE...");
                counter++;  // Increment counter
            }  // May run infinitely due to caching
            System.out.println("Thread 1: Flag is now TRUE!");
            System.out.println("Counter: " + counter);
        });

        // Thread 2: Changes flag to true after 2 sec
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);  // Wait 3 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;  // Update flag
            System.out.println("Thread 2: Set flag = TRUE");
            System.out.println("Thread 2 Counter value " + counter);
        });

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
    }
}

/*
This code demonstrates a visibility issue with the `volatile` keyword in Java.
When `flag` is not declared as `volatile`, the first thread may not see the update made by the second thread, leading to an infinite loop.

Why is this a problem?
-flag is updated in Thread 2.
-But Thread 1 may be reading the old flag value from CPU cache, not from main memory.
-So Thread 1 keeps looping forever (infinite loop).
This happens because:
-In Java, each thread has its own CPU cache (local copy of variables).
-If a variable is not marked volatile, Java does NOT guarantee visibility of changes between threads.

Stale counter value:
Since counter is not synchronized/volatile, its final value might be inconsistent between threads.

Note :
I commented out the print statements in the first thread because
System.out.println(...) inside the loop causes memory flushes and I/O synchronization.
This breaks the caching behavior, so Thread 1 gets the updated value of flag.


Definition :
In Java, volatile is a keyword you put before a variable.
It means:
   - Always read from main memory, not from thread’s local CPU cache.
   - Always write directly to main memory, not just in cache.
   - This guarantees visibility of changes across threads.
* */