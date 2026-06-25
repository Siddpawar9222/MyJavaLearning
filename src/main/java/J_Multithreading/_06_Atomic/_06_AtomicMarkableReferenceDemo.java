package J_Multithreading._06_Atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class _06_AtomicMarkableReferenceDemo {

    public static void main(String[] args)
            throws InterruptedException {

        AtomicMarkableReference<String> session =
                new AtomicMarkableReference<>(
                        "USER_SESSION",
                        false
                );

        Thread reader = new Thread(() -> {

            boolean[] markHolder =
                    new boolean[1];

            String currentSession =
                    session.get(markHolder);

            System.out.println(
                    "Reader Thread"
            );

            System.out.println(
                    "Session = "
                            + currentSession
            );

            System.out.println(
                    "Expired = "
                            + markHolder[0]
            );
        });

        Thread expirer = new Thread(() -> {

            boolean success =
                    session.compareAndSet(
                            "USER_SESSION",
                            "USER_SESSION",
                            false,
                            true
                    );

            System.out.println(
                    "\nExpirer Thread"
            );

            System.out.println(
                    "Session Marked Expired = "
                            + success
            );
        });

        reader.start();
        reader.join();

        expirer.start();
        expirer.join();

        boolean[] markHolder =
                new boolean[1];

        String value =
                session.get(markHolder);

        System.out.println(
                "\nFinal State"
        );

        System.out.println(
                "Session = "
                        + value
        );

        System.out.println(
                "Expired = "
                        + markHolder[0]
        );
    }
}