package J_Multithreading.concurrency._07ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fairness {
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
- We already saw(In Basic.java) starvation problem, Most waiting Thread sometimes don't get lock (FIFO behavior). It is totally depends on upons OS+CPU+JVM
- Using ReentrantLock we can enable FIFO. Still it is approximate behavior doesn't guarantee 100% accuracy.
* */