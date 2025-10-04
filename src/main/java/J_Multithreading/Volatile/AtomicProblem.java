package J_Multithreading.Volatile;

public class AtomicProblem {
    private static volatile int counter = 0;  // volatile gives visibility, NOT atomicity

    public static void main(String[] args) throws InterruptedException {
        // Create 2 threads that each increment counter 1000 times
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter++;  // Not atomic
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter++;  // Not atomic
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Counter (Expected 2000): " + counter);
    }
}

/*
What is Atomicity?
An operation is atomic if it cannot be broken — it is completed fully or not at all, without interference from other threads.

Is counter++ Atomic?
NO! It looks simple, but it’s not atomic.

Internally, counter++ is actually 3 steps:

// Pseudo-code for counter++
int temp = counter;     // Step 1: Read
temp = temp + 1;        // Step 2: Modify
counter = temp;         // Step 3: Write

If two threads run this at the same time, they may interfere with each other, and updates can be lost.

Run Multiple Times → You’ll often see output like:
Final Counter (Expected 2000): 1739
* */