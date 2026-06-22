package J_Multithreading.concurrency;



import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// SharedBufferWithCondition.java
class SharedBufferWithCondition {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;

    // One lock controls access to the buffer
    private final ReentrantLock lock = new ReentrantLock();

    // Two separate condition queues — very precise signaling
    private final Condition notFull  = lock.newCondition(); // Producer sleeps here
    private final Condition notEmpty = lock.newCondition(); // Consumer sleeps here

    public SharedBufferWithCondition(int capacity) {
        this.capacity = capacity;
    }

    // Called by Producer thread
    public void produce(int item) throws InterruptedException {
        lock.lock();      // Acquire the lock
        try {
            // Wait until there is space in the buffer
            while (buffer.size() == capacity) {
                System.out.println("[Producer] Buffer FULL. Waiting on notFull...");
                notFull.await(); // Sleep on notFull condition (releases lock)
            }

            // Space is available — add the item
            buffer.add(item);
            System.out.println("[Producer] Produced: " + item + " | Size: " + buffer.size());

            // Signal ONLY the consumer — no need to wake up other producers
            notEmpty.signal(); // 'Buffer is not empty anymore — Consumer can proceed'

        } finally {
            lock.unlock(); // ALWAYS unlock in finally block
        }
    }

    // Called by Consumer thread
    public void consume() throws InterruptedException {
        lock.lock();
        try {
            // Wait until there is at least one item
            while (buffer.isEmpty()) {
                System.out.println("[Consumer] Buffer EMPTY. Waiting on notEmpty...");
                notEmpty.await(); // Sleep on notEmpty condition (releases lock)
            }

            // Item available — remove it
            int item = buffer.poll();
            System.out.println("[Consumer] Consumed: " + item + " | Size: " + buffer.size());

            // Signal ONLY the producer — buffer now has space
            notFull.signal(); // 'Buffer is not full anymore — Producer can proceed'

        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {

    private final SharedBufferWithCondition buffer;

    public Producer(SharedBufferWithCondition buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 6; i++) {
            try {
                buffer.produce(i);
                Thread.sleep(100); // produces faster than consumer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("[Producer] Done producing.");
    }
}

class Consumer implements Runnable {

    private final SharedBufferWithCondition buffer;

    public Consumer(SharedBufferWithCondition buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                buffer.consume();
                Thread.sleep(300); // consumes slower than producer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("[Consumer] Done consuming.");
    }
}

public class _11_Conditions {
    static void main() {
        int capacity = 3;
        SharedBufferWithCondition buffer = new SharedBufferWithCondition(capacity);

        Thread producerThread = new Thread(new Producer(buffer), "Producer");
        Thread consumerThread = new Thread(new Consumer(buffer), "Consumer");

        producerThread.start();
        consumerThread.start();

    }
}
/*
* In this example, we have a shared buffer with a fixed capacity. The producer thread produces items and adds them to the buffer, while the consumer thread consumes items from the buffer.
* wait, notify,notifyAll used to use same waiting area (same queue). Hence calling notify wake up all threads from it , unnecessary computations
* */