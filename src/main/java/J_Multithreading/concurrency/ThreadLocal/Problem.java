package J_Multithreading.concurrency.ThreadLocal;

public class Problem {
}
/*
Why do we need ThreadLocal ?
When we use multiple threads, they often share the same objects → which can cause data corruption or unexpected results.
Sometimes, instead of sharing, we want each thread to have its own copy of a variable, so they don’t interfere with each other.

That’s where ThreadLocal comes in:
It gives each thread its own isolated variable, even if all threads use the same ThreadLocal object.
* */