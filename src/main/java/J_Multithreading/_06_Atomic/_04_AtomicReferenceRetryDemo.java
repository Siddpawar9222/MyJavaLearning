package J_Multithreading._06_Atomic;

import java.util.concurrent.atomic.AtomicReference;

public class _04_AtomicReferenceRetryDemo {
    record Account(int balance) {

        @Override
            public String toString() {
                return "Account{balance=" + balance + "}";
            }
        }

    private static final AtomicReference<Account> accountRef =
            new AtomicReference<>(new Account(100));

    public static void addMoney(int amount) {

        while (true) {

            // Step 1 : Read current object
            Account currentAccount = accountRef.get();

            // Step 2 : Calculate new state
            Account updatedAccount =
                    new Account(
                            currentAccount.balance() + amount
                    );

            // Step 3 : Try CAS
            if (accountRef.compareAndSet(
                    currentAccount,
                    updatedAccount
            )) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " updated balance from "
                                + currentAccount.balance()
                                + " to "
                                + updatedAccount.balance()
                );

                break;
            }

            System.out.println(
                    Thread.currentThread().getName()
                            + " CAS Failed. Retrying..."
            );
        }
    }

     static void main(String[] args)
            throws InterruptedException {

        Thread t1 =
                new Thread(() -> addMoney(10), "T1");

        Thread t2 =
                new Thread(() -> addMoney(20), "T2");

        Thread t3 =
                new Thread(() -> addMoney(30), "T3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(
                "\nFinal Account = "
                        + accountRef.get()
        );
    }

}
/*
Run program multiple times you will something like
T1 CAS Failed. Retrying...
Threads can be success or fails. But what about failed threads. We don't want to loss data of those thread
Hence CAS retrying mechanisum used here
AtomicReference Methods :
| Method                | Automatic CAS Retry? |
| --------------------- | -------------------- |
| `compareAndSet()`     | ❌ No                 |
| `weakCompareAndSet()` | ❌ No                 |
| `set()`               | ❌ No CAS involved    |
| `lazySet()`           | ❌ No CAS involved    |
| `updateAndGet()`      | ✅ Yes                |
| `getAndUpdate()`      | ✅ Yes                |
| `accumulateAndGet()`  | ✅ Yes                |
| `getAndAccumulate()`  | ✅ Yes                |

AtomicReference compareAndSet operation is not CAS retry, we need to enable mannually. AtomicIntger, AtomicLong and AtomicBoolean operation already CAS retry , so we can direcly use here
* */