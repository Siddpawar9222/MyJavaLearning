package J_Multithreading.concurrency._04Producer_Consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue =  new ArrayBlockingQueue<Integer>(5);

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    queue.put(i); // waits if queue is full
                    System.out.println("Produced: " + i);
                    Thread.sleep(200); // simulate production time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    int item = queue.take(); // waits if queue is empty
                    System.out.println("Consumed: " + item);
                    Thread.sleep(400); // simulate consumption time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

    }
}
