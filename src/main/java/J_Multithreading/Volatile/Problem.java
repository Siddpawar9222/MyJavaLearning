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
                Thread.sleep(2000);  // Wait 2 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;  // Update flag
            System.out.println("Thread 2: Set flag = TRUE");
        });

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
    }
}
