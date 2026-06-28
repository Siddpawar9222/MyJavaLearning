package J_Multithreading._05_Locks._003_StampedLock;

import java.util.concurrent.locks.StampedLock;

public class _02_StampedLockDemo {

    private static String config = "jdbc:mysql://localhost:3306/app";

    private static final StampedLock lock = new StampedLock();

    public static void main(String[] args) {

        Thread writer = new Thread(() -> {

            int count = 1;

            while (true) {

                sleep(3000);

                long stamp = lock.writeLock();

                try {

                    config =
                            "jdbc:mysql://localhost:3306/app_v"
                                    + count++;

                    System.out.println(
                            "Writer Updated Config -> "
                                    + config);

                } finally {
                    lock.unlockWrite(stamp);
                }

            }

        }, "Writer");

        Thread reader = new Thread(() -> {

            while (true) {

                long stamp = lock.tryOptimisticRead();

                String currentConfig = config;

                // Simulate slow processing
                sleep(1000);

                if (!lock.validate(stamp)) {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " -> Optimistic Read Failed!");

                    stamp = lock.readLock();

                    try {
                        currentConfig = config;
                    } finally {
                        lock.unlockRead(stamp);
                    }
                } else {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " -> Optimistic Read Success");
                }

                System.out.println(
                        Thread.currentThread().getName()
                                + " -> Config = "
                                + currentConfig);

                sleep(1000);
            }

        }, "Reader");

        writer.start();
        reader.start();
    }

    private static void sleep(long millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


/*
 *Here we keep 1s sleep in reader thread to simulate more read processing and 3s sleep in writer thread to simulate slow writing operation.
 * After some iteration you will see Optimistic Read Failed!
 *
StampedLock provides:
Version-based validation not Data-level change tracking

It can tell:
Is there any write occurred after my optimistic read started ?

It cannot tell:
Which object changed
Which field changed
What value changed
*
If write occurred, validation returns false and the reader should retry using a proper read lock.
 * */