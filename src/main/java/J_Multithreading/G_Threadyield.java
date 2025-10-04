package J_Multithreading;


public class G_Threadyield {

	public static void main(String[] args) {
		
		Runnable thread0 =()->{
			Thread.yield();  //It stops the current running thread(thread-0) and give chance to main method to executed the main thread
			for (int i = 0; i < 6; i++) {
				System.out.println(i + " : " + Thread.currentThread().getName() );
			}
		};
		Thread t =new Thread(thread0);
		t.start();
		
		
		for (int i = 0; i < 6; i++) {
			System.out.println(i + " : " + Thread.currentThread().getName() );
		}

	}

}
/*
It is a hint to the thread scheduler: “I am ready to pause, let other threads run if they want.”
But it does not guarantee that another thread will get the CPU.
The current thread may continue running if no other thread of the same/equal priority is waiting.
It is used rarely in real-world apps (mostly for testing or demonstration).
* */