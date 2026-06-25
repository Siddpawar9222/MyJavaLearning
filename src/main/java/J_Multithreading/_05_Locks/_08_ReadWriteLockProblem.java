package J_Multithreading._05_Locks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource {
    private int value = 0;

    private final ReadWriteLock rWLock = new ReentrantReadWriteLock();

    private final Lock readLock = rWLock.readLock();      // shared
    private final Lock writeLock = rWLock.writeLock();    // exclusive

    public int getValue() {
        readLock.lock();
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " read value : " + this.value);
            return this.value;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
        }
    }

    public void setValue(int value) {
        writeLock.lock();
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " writing value : " + value);
            this.value = value;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }
}

public class _08_ReadWriteLockProblem {
    static void main() throws InterruptedException {
        SharedResource sharedResource = new SharedResource();

        Thread r1 = new Thread(sharedResource::getValue);
        Thread r2 = new Thread(sharedResource::getValue);
        Thread r3 = new Thread(sharedResource::getValue);


        Thread w1 = new Thread(() -> {
            sharedResource.setValue(10);
        });
        Thread w2 = new Thread(() -> {
            sharedResource.setValue(100);
        });
        Thread w3 = new Thread(() -> {
            sharedResource.setValue(1000);
        });

        r1.start();
        r2.start();
        r3.start();

        w1.start();
        w2.start();
        w3.start();

        // Wait main thread for all threads to finish(no need)
        r1.join();
        r2.join();
        r3.join();

        w1.join();
        w2.join();
        w3.join();

        System.out.println("Main thread end");
    }
}
/*
- Above Problem explain How ReadWrite Problem can be solved using ReadWriteLock.
- Run program and see reader threads executed same time but writer thread executed one by one.
- Let's suppose there are  multiple read threads who acquired lock and there is only one write thread. Also read threads keep coming , So read threads will acquire lock continuously, write thread will starve. This is called Write Starvation. To avoid this we can make ReadWriteLock fair.
- Same like Reentrant Lock we can make ReentrantReadWriteLock fair using
ReadWriteLock rWLock = new ReentrantReadWriteLock(true);

Lock downgrade :
* */