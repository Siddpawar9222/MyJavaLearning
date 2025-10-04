package J_Multithreading;


class IWorker0 extends Thread{
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Working...");
		}
		System.out.println("Stopped because of interrupt");
	}
}

class IWorker extends  Thread {
	@Override
	public void run() {
		while (!isInterrupted()) {  // keep working until not interrupted
			System.out.println("Working...");
			try {
				Thread.sleep(500); // may throw InterruptedException
			} catch (InterruptedException e) {
				System.out.println("Interrupted while sleeping");
				break; // exit loop
			}
		}
		System.out.println("Thread exiting gracefully");
	}
}

public class I_ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {

		IWorker0 iWorker0 = new IWorker0();
		iWorker0.start();
		Thread.sleep(2000);
		iWorker0.interrupt();


		IWorker iWorker = new IWorker();
		iWorker.start();

		Thread.sleep(5000);
		iWorker.interrupt();
	}

}
/*
 Methods :
 interrupt() : interrupt the thread gracefully using following methods, before this method java had stop() method
 which forcefully shut the thread, now deprecated
 isInterrupted() : Check whether thread is interrupted or not
 interrupted()  :  Static method that checks whether the current thread has been interrupted and clears the interrupted status.
       - if true --> returns true--> Make interrupted status to false
       - if false ---> return false
* */