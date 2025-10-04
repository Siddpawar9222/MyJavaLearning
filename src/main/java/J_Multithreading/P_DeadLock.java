package J_Multithreading;

public class P_DeadLock {

	public static void main(String[] args) {

		Object pen1 = new Object();
		Object pen2 = new Object();

		Thread personA = new Thread(() -> {
			synchronized (pen1) {
				System.out.println("Person A picked up pen 1");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Person A waiting for Pen 2");

				synchronized (pen2) {
					System.out.println("Person A picked up pen 2");
				}
			}
		});

		Thread personB = new Thread(() -> {
			synchronized (pen2) {
				System.out.println("Person B picked up pen 2");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Person B waiting for Pen 1");

				synchronized (pen1) {
					System.out.println("Person B picked up pen 1");
				}
			}
		});
         
		personA.start();
		personB.start();
	}

}
/*
To understand deadlock, let's consider an analogy with two people and two pens. Each person needs both pens to complete their task. Now, imagine the following scenario:


Person A picks up pen 1.
Person B picks up pen 2.
Person A realizes they need pen 2 and tries to pick it up but can't because Person B is holding it.
At the same time, Person B realizes they need pen 1 and tries to pick it up but can't because Person A is holding it.


Now, both people are stuck waiting for the other person to release the pen they need to proceed. This is a deadlock situation because neither person can make progress, and they remain deadlocked indefinitely.

Definition :
Deadlock happens when two or more threads are waiting for each other forever.
    - Each thread has locked some resource.
    - Each is waiting to get the other resource.
    - But since no one releases, all threads get stuck.
       Result: Program hangs.

Fixes: lock ordering, timeouts (tryLock), better concurrency utilities, or detection + recovery.
*/