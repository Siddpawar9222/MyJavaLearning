package J_Multithreading._03_Synchronization;

import java.util.Random;

public class _07_LivelockSolved {

    static volatile boolean personAOnLeft = true;
    static volatile boolean personBOnLeft = true;

    public static void main(String[] args) {

        Random random = new Random();

        Thread personA = new Thread(() -> {

            while (true) {

                if (personAOnLeft == personBOnLeft) {

                    System.out.println("A: You go first.");

                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    personAOnLeft = !personAOnLeft;
                } else {

                    System.out.println("A Passed");
                    break;
                }
            }
        });

        Thread personB = new Thread(() -> {

            while (true) {

                if (personAOnLeft == personBOnLeft) {

                    System.out.println("B: No, you go first.");

                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    personBOnLeft = !personBOnLeft;
                } else {

                    System.out.println("B Passed");
                    break;
                }
            }
        });

        personA.start();
        personB.start();
    }
}

/*

Without delay:

Time 0:
A switches side
B switches side

Time 1:
A switches side
B switches side

Again collision

With random delay:
A waits 200 ms
B waits 700 ms

A changes side first

Now:
A = Right
B = Left
* */