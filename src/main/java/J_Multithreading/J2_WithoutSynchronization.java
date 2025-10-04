package J_Multithreading ;


//why synchronization is need ?
class Counter1 {
    static int count = 0;

   synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class J2_WithoutSynchronization {
	public static void main(String args[]) {
        Counter1 counter1 = new Counter1();
        Counter1 counter2 = new Counter1();

        // Thread 1 increments the counter 1000 times
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter1.increment();
            }
        });

        // Thread 2 increments the counter 1000 times
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter1.increment();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter2.increment();
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter2.increment();
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Wait for both threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final counter value
        System.out.println("Final counter value: " + counter1.getCount());
	}
}

/*
To see Problem Run Program multiple time, we can see inconsistent result.
To get correct result 
   static synchronized void increment() {
        count++;
    }
 */