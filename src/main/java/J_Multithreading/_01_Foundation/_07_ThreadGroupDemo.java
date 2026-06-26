package J_Multithreading._01_Foundation;

public class _07_ThreadGroupDemo {

	public static void main(String[] args) {
		
		//work
		Runnable myRunnable = ()->{
			System.out.println("Thread Executing : " + Thread.currentThread().getName());
		};
		
		// Create a thread group
		ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup") ;
		
		// Create threads within the thread group
		Thread thread1 = new Thread(myThreadGroup, myRunnable ) ;
		Thread thread2 = new Thread(myThreadGroup, myRunnable ) ;
		thread1.start();
		thread2.start();
		
        // Get information about the thread group
        System.out.println("Thread group name: " + myThreadGroup.getName());
        System.out.println("Active thread count: " + myThreadGroup.activeCount());

	}

}
/*

Think of a thread group as a container or a category that holds a group of threads together. Just like you can organize files into folders on your computer, you can organize threads into thread groups in Java.

A thread pool is a collection of threads used to execute tasks concurrently.
A thread group is a mechanism for organizing threads into a hierarchical structure for management and monitoring.

 */