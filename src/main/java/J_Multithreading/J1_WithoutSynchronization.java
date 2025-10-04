package J_Multithreading ;


//why synchronization is need ?
class Counter {
    private int count = 0;

    void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class J1_WithoutSynchronization {
	public static void main(String args[]) {
        Counter counter = new Counter();

        // Thread 1 increments the counter 1000 times
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Thread 2 increments the counter 1000 times
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to complete
        try {
            System.out.println("Starting Thread1.....");
            thread1.join();
            System.out.println("Thread1 finished. Now waiting for Thread2....");
            thread2.join();
            System.out.println("Both threads finished. Continuing main...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final counter value
        System.out.println("Final counter value: " + counter.getCount());
	}
}

/*
To see Problem Run Program multiple time, we can see inconsistent result.
To get correct result 
 synchronized void increment() {
        count++;
    }
 */