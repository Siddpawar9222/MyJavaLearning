package J_Multithreading.Volatile;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    static class User {
        String name;

        User(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    static void main() throws InterruptedException {
        User john = new User("John");
        User alice = new User("Alice");
        User bob = new User("Bob");

        AtomicReference<User> currentUser = new AtomicReference<>(john);

        Thread t1 = new Thread(()->{
            boolean hasSet = currentUser.compareAndSet(john, alice);
            System.out.println("T1 " + hasSet);
        });

        Thread t2 = new Thread(()->{
            boolean hasSet = currentUser.compareAndSet(john, bob);
            System.out.println("T2 " + hasSet);
        });

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println("Final currentUser value is " + currentUser.get());
    }
}


/*
Problem:
--------
AtomicInteger, AtomicLong and AtomicBoolean only work with primitive values.

Example:
    AtomicInteger count = new AtomicInteger(0);

But in real applications we often share objects between threads:

    User currentUser
    AppConfig config
    Cache cache
    Session session

We need a way to update object references atomically.

AtomicReference solves this problem.

------------------------------------------
What does AtomicReference protect?
------------------------------------------

It protects the REFERENCE (memory address), not the object's fields.

Example:

    AtomicReference<User> ref =
        new AtomicReference<>(john);

This is atomic:

    ref.set(alice);

because the reference changes from john -> alice atomically.

------------------------------------------
What is compareAndSet() ?
------------------------------------------

compareAndSet(expectedValue, newValue)

Example:

    ref.compareAndSet(john, alice);

Internally:

    if(currentReference == john)
        currentReference = alice;

This entire operation happens atomically.

------------------------------------------
Important Point
------------------------------------------

compareAndSet() compares references,
NOT object contents.

Example:

    User u1 = new User("John");
    User u2 = new User("John");

Even though names are same:

    u1 != u2

because they are different objects.

Therefore:

    ref.compareAndSet(u2, alice)

will fail if ref currently holds u1.

CAS checks memory address equality.

------------------------------------------
In this example : (Dry run while considering concurrency and parallelium)
------------------------------------------

Initially:

    currentUser -> john

Thread T1:

    compareAndSet(john, alice)

Thread T2:

    compareAndSet(john, bob)

Possible sequence:

Step 1:
    currentUser = john

Step 2:
    T1 succeeds
    currentUser = alice

Step 3:
    T2 checks

    Is currentUser == john ?

    No

Therefore:

    T2 returns false

Result:

    Only ONE thread succeeds.

This is the power of CAS.

------------------------------------------
Why not use normal code?
------------------------------------------

Unsafe:

    if(currentUser == john){
        currentUser = alice;
    }

Two threads can enter simultaneously.

Both may see john.

Both may update.

Race condition occurs.

AtomicReference performs check + update
as a single atomic operation.

------------------------------------------
Real World Use Cases
------------------------------------------

1. Configuration Reload

    AtomicReference<AppConfig>

    Old config -> New config

2. Cache Swapping

    AtomicReference<Map<String,Object>>

    Replace entire cache atomically.

3. Feature Flags

    AtomicReference<FeatureFlags>

4. Session/User State

    AtomicReference<User>

5. Immutable Snapshot Pattern

    Readers read old snapshot.
    Writer creates new snapshot.
    Atomic swap performed.

------------------------------------------
Very Important Limitation
------------------------------------------

AtomicReference protects reference only.

Suppose:

    AtomicReference<User> ref;

This is safe:

    ref.set(new User("Alice"));

But this is NOT automatically safe:

    ref.get().name = "Bob";

because now we are modifying the object's
internal state, not replacing the reference.

AtomicReference does NOT make User thread-safe.

------------------------------------------
Best Practice
------------------------------------------

Use immutable objects.

Example:

    final class User {
        private final String name;
    }

Instead of modifying User:

    ref.get().name = "Bob";

Create new object:

    ref.set(new User("Bob"));

This approach is common in
high-performance concurrent systems.

------------------------------------------
Mental Model
------------------------------------------

AtomicInteger
    -> CAS on int

AtomicLong
    -> CAS on long

AtomicBoolean
    -> CAS on boolean

AtomicReference<User>
    -> CAS on User reference

AtomicReference<AppConfig>
    -> CAS on AppConfig reference

AtomicReference<Cache>
    -> CAS on Cache reference

Whenever multiple threads need to safely
replace a shared object without locks,
AtomicReference is usually the first choice.

Atomic Classes :
| Class                      | Protects              |
| -------------------------- | --------------------- |
| AtomicInteger              | int value             |
| AtomicLong                 | long value            |
| AtomicBoolean              | boolean value         |
| AtomicReference<T>         | object reference      |
| AtomicStampedReference<T>  | reference + version   |
| AtomicMarkableReference<T> | reference + mark flag |
*/