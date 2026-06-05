package J_Multithreading.concurrency.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resources {

    Lock lock = new ReentrantLock();

    void doingSomething() {
        try {
            lock.lock();

            System.out.println(Thread.currentThread().getName());

            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        } finally {
            lock.unlock();
        }
    }

}

public class Basic {
    static void main() throws InterruptedException {
        Resources resources = new Resources();

        Thread thread0 = new Thread(resources::doingSomething);
        Thread thread1 = new Thread(resources::doingSomething);
        Thread thread2 = new Thread(resources::doingSomething);

        thread0.start();
        thread1.start();
        thread2.start();

        thread0.join();
        thread1.join();
        thread2.join();

        System.out.println("main end");

    }
}
/*
- We have created three thread and trying to access one common resources, Just like synchronized keyword do
- Now it works same like synchronized but we are appliying lock using ReentrantLock.
- Run Program multiple times i found out How thread starvation look (waiting thread0, thread1, thread2 , but lock get randomnly, decided by CPU + JVM)
* */