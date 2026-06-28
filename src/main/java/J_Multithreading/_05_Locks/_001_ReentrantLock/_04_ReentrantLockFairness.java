package J_Multithreading._05_Locks._001_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _04_ReentrantLockFairness {
    static void main() {
        Lock lock = new ReentrantLock(true);

        Runnable task = () -> {
            lock.lock();

            try {
                System.out.println(
                        Thread.currentThread().getName()
                );
            } finally {
                lock.unlock();
            }
        };
    }
}
/*
- We already saw(In _03_ReentrantLockBasic.java) starvation problem, Most waiting Thread sometimes don't get lock (FIFO behavior). It is totally depends on upons OS+CPU+JVM
- Using ReentrantLock we can enable FIFO. Still it is approximate behavior doesn't guarantee 100% accuracy.
* */