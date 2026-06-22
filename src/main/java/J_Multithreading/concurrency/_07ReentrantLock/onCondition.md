---

# How wait() and notify() work with synchronized

Suppose we have a producer-consumer system.

```text
Producer -> Adds items to queue
Consumer -> Removes items from queue
```

Shared queue size = 5

---

Using `synchronized`:

```java
synchronized(queue) {

    while(queue.isEmpty()) {
        queue.wait();
    }

    queue.remove();

    queue.notifyAll();
}
```

Here all waiting threads go into **one waiting room**.

```text
Object Monitor

    Waiting Queue
    -----------------
    Producer-1
    Producer-2
    Consumer-1
    Consumer-2
    Consumer-3
```

Everybody is mixed together.

---

Now suppose:

```text
Queue becomes non-empty
```

A producer calls:

```java
notifyAll();
```

Then:

```text
Producer-1 wakes up
Producer-2 wakes up
Consumer-1 wakes up
Consumer-2 wakes up
Consumer-3 wakes up
```

But actually only consumers needed to wake up.

The producers woke up unnecessarily.

This causes:

```text
Context Switching
CPU Waste
Lock Contention
```

---

# ReentrantLock Solution

`ReentrantLock` allows multiple waiting rooms.

```java
ReentrantLock lock = new ReentrantLock();

Condition notEmpty = lock.newCondition();
Condition notFull = lock.newCondition();
```

Now we have:

```text
Lock

    notEmpty Queue
    ----------------
    Consumer-1
    Consumer-2
    Consumer-3

    notFull Queue
    ----------------
    Producer-1
    Producer-2
```

Notice:

```text
Consumers wait separately
Producers wait separately
```

This is impossible with synchronized.

---

# Example

Let's create a bounded queue.

Queue capacity = 5

---

Producer

```java
lock.lock();

try {

    while(queue.size() == 5) {
        notFull.await();
    }

    queue.add(item);

    notEmpty.signal();

} finally {
    lock.unlock();
}
```

---

Consumer

```java
lock.lock();

try {

    while(queue.isEmpty()) {
        notEmpty.await();
    }

    queue.remove();

    notFull.signal();

} finally {
    lock.unlock();
}
```

---

# What is happening internally?

Suppose queue is empty.

Consumers arrive:

```text
Consumer-1 -> wait
Consumer-2 -> wait
Consumer-3 -> wait
```

They go into:

```text
notEmpty queue
```

---

Now Producer adds one item.

```java
notEmpty.signal();
```

Only one consumer wakes up.

```text
Consumer-1 wakes up

Consumer-2 still sleeping
Consumer-3 still sleeping
```

Very efficient.

---

# Mapping to synchronized

Think of it like this:

| synchronized | ReentrantLock |
| ------------ | ------------- |
| wait()       | await()       |
| notify()     | signal()      |
| notifyAll()  | signalAll()   |

Example:

```java
wait();
```

becomes

```java
condition.await();
```

---

```java
notify();
```

becomes

```java
condition.signal();
```

---

```java
notifyAll();
```

becomes

```java
condition.signalAll();
```

---

# The Main Idea

With `synchronized`, every object has:

```text
ONE lock
ONE waiting queue
```

With `ReentrantLock`, you can have:

```text
ONE lock
MANY waiting queues (Conditions)
```

This ability to create **multiple independent waiting queues** is why classes like `ArrayBlockingQueue`, `LinkedBlockingQueue`, and many other Java concurrent collections use `ReentrantLock` internally instead of `synchronized`.
