package J_Multithreading.Volatile;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSolution {
    private static AtomicInteger counter = new AtomicInteger(0);  // Atomic & thread-safe

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();  // Atomic increment
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();  // Atomic increment
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Counter (Expected 2000): " + counter.get());
    }
}


/*
How to Make It Atomic?
1. Use synchronized

synchronized(SomeClass.class) {
    counter++;
}
2. Or use AtomicInteger

private static AtomicInteger counter = new AtomicInteger(0);

counter.incrementAndGet(); // This is atomic!
* */
