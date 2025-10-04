package J_Multithreading.WaitNotifyNotifyAll;

//Interthread Commumication


class SharedBuffer {
    private int data;
    private boolean available = false;

    // Producer puts value in buffer
    synchronized void produce(int value) throws InterruptedException {
        while (available) {
            wait(); // wait if data already available (buffer full)
        }
        data = value;
        available = true;
        System.out.println("Produced: " + value);
        notify(); // notify consumer that data is ready
    }

    // Consumer takes value from buffer
    synchronized int consume() throws InterruptedException {
        while (!available) {
            wait(); // wait if buffer is empty
        }
        available = false;
        System.out.println("Consumed: " + data);
        notify(); // notify producer that buffer is empty
        return data;
    }
}

class Producer extends Thread {
    private final SharedBuffer buffer;

    Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                buffer.produce(i);
                Thread.sleep(500); // simulate some delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private final SharedBuffer buffer;

    Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                buffer.consume();
                Thread.sleep(1000); // simulate slower consumption
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}

/*
Problem Statement :
We are building Producer and consumer program, Producer produce data and consumer consume it sequentially

Solution : Draw diagram and you will understand better, dont mug up concept , understand requirement and convert it to logic


Object’s monitor (lock) : When any thread accessing object , java lock that object so no other thread can access it .Can be done by synchronised keyword.
What if we didn’t use synchronized ?
Even if JVM allowed it, problems would appear:
    - Race condition: available might be read/modified at the same time by producer and consumer, leading to wrong results.
    - Lost signals: Producer might call notify() just before consumer calls wait(), and consumer would sleep forever (missed wake-up).

Rule in Java
wait() and notify() can only be called inside a synchronized block/method.
If you try without, JVM throws:

java.lang.IllegalMonitorStateException


wait() Work?
A thread calls wait() on an object → it releases the lock and goes into the waiting state.
It will just sit there, doing nothing, until someone calls notify() or notifyAll() on the same object.


notify() work?
When one thread calls notify() on the same object, it wakes up one waiting thread (not all).
The choice of which thread gets awakened is made by the JVM (not you). You can’t guarantee which one if multiple threads are waiting.
The awakened thread doesn’t start running immediately.
      It first competes to re-acquire the lock on that object.
      only after it gets the lock, it continues execution right after wait().


notifyAll() ?
This wakes all waiting threads on that object.
Then they all compete for the lock, and whichever wins will proceed first.
Others will still wait until they get the lock.



Why while loop instead of if loop ?

Problem 1: Spurious wakeups
In Java, a thread waiting on wait() can sometimes wake up without being notified (this is rare, but possible — JVM allows it).
If that happens and you only use if, the consumer would run without condition actually being true.

Problem 2: Multiple threads waiting

Imagine you have 2 consumers waiting for available.
Producer sets available = true and calls notify().
➡Only one thread should consume, but if both wake up, we must check again whether available is still true.

    If we use if, the second consumer might also consume incorrectly.
    If we use while, the second consumer will check again and go back to waiting.


Correct Approach → while

That’s why the official rule in Java concurrency is:
Always call wait() inside a while (condition not met) loop, not an if.
 */