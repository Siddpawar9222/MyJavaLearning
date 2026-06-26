package J_Multithreading._05_Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _05_LockControlDemo {
    static void main() throws InterruptedException {
        Lock lock = new ReentrantLock();

        if(lock.tryLock()) {
            try {
                System.out.println("Lock acquired");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Could not acquire lock");
        }


        // We can have even timeout support
        Lock lock1 = new ReentrantLock();

        if(lock1.tryLock(2, TimeUnit.SECONDS)) {
            try {
                System.out.println("Got lock");
            } finally {
                lock1.unlock();
            }
        } else {
            System.out.println("Timeout occurred");
        }


        // interrupt a waiting thread

        try {
            lock.lockInterruptibly();

            try {
                // critical section
            } finally {
                lock.unlock();
            }

        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting");
        }
    }
}

/*
* Problem 1 : No control over lock acquisition

With synchronized, a thread either:
  gets the lock and enters or waits indefinitely

You cannot say:
"Try for 2 seconds, then give up."

synchronized (obj) {
    // critical section
}
*
If another thread owns obj, your thread waits forever.
*
*
Problem 2: No timeout support

With synchronized:

synchronized(obj) {
    // wait forever if lock unavailable
}

No timeout mechanism exists.

* Problem 3: Cannot interrupt a waiting thread

This is a very important limitation that many developers forget.

synchronized(obj) {
   // waiting
}

If thread is blocked waiting for lock:
thread.interrupt();

It still cannot leave the lock queue.
It keeps waiting.

ReentrantLock Solution
lock.lockInterruptibly();
* */