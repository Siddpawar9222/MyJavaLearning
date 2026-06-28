package J_Multithreading._05_Locks._002_ReadWriteLock;

public class _01_ReadWriteLockBasic {
}
/*
 * So far we have seen only one thread can acquire an object and no other thread can enter at the same time
 * But what we have a reader and reading operation is non-destructive So if you want to allow reader thread to read a value how we can do it
 * Solution : ReadWriteLock
 * Usage :
  - Solve ReadWriteProblem
  - Lock downgrade
  Limitation :
    - Lock Upgrade(We can do it, but multiple lock and unlock operation needed, Awkward and error-prone)
 * */