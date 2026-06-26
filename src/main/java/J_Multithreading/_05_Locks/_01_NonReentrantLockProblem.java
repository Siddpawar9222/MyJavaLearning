package J_Multithreading._05_Locks;

class MyLock {

    private boolean locked = false;

    public synchronized void lock() throws InterruptedException {

        while (locked) {
            wait();
        }

        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notify();
    }
}
public class _01_NonReentrantLockProblem {
    private final MyLock lock = new MyLock();

    public void methodA() throws InterruptedException {

        lock.lock();

        try {
            System.out.println("Entered methodA");

            methodB();

        } finally {
            lock.unlock();
        }
    }

    public void methodB() throws InterruptedException {

        lock.lock();

        try {
            System.out.println("Entered methodB");

        } finally {
            lock.unlock();
        }
    }

    static void main() throws InterruptedException {
           _01_NonReentrantLockProblem problem = new _01_NonReentrantLockProblem();
           problem.methodA();
    }
}

/*
Non-Reentrant Lock :
- we have created here a custom lock.
- Main thread already acquire lock  when it execute methodA().
- When it execute methodB()(which is inside methodA()) it tried to acquire lock again , but lock already locked and hence went in waiting state and deadlock happens.
-
 Above code does only
  Is lock occupied?  YES / NO

It does not remember:
   Which thread owns the lock?
   How many times was it acquired?

- synchronized keyword also Reentrant by default mean Same thread can acquire the lock multiple times.

 synchronized void methodA() {
    methodB();
}

synchronized void methodB() {
}

 But writing code is complex using it. Reentrant provides extra feature than synchronized
This problem can be solved using ReentrantLock

| Feature               | synchronized | ReentrantLock |
| --------------------- | ------------ | ------------- |
| Reentrant             | ✅            | ✅             |
| Fairness              | ❌            | ✅             |
| tryLock()             | ❌            | ✅             |
| Timeout               | ❌            | ✅             |
| Interruptible waiting | ❌            | ✅             |
| Multiple Conditions   | ❌            | ✅             |



* */