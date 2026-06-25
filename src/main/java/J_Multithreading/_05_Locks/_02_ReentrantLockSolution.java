package J_Multithreading._05_Locks;

import java.util.concurrent.locks.ReentrantLock;

public class _02_ReentrantLockSolution {
    private final ReentrantLock lock = new ReentrantLock();

    public void saveUser() {

        lock.lock();

        try {
            validateUser();
        } finally {
            lock.unlock();
        }
    }

    private void validateUser() {

        lock.lock();

        try {
            System.out.println("Validating");
        } finally {
            lock.unlock();
        }
    }

    static void main() {
        _02_ReentrantLockSolution solution = new _02_ReentrantLockSolution();
        solution.validateUser();
    }
}
/*
saveUser()
    lock count = 1

validateUser()
    lock count = 2

validateUser() returns
    lock count = 1

saveUser() returns
    lock count = 0

"Reentrant" means:
Same thread can acquire the lock multiple times.
It store information of
   Which thread owns the lock?
   How many times was it acquired?

* */