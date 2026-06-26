package J_Multithreading._01_Foundation;

class ThreadPriority extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getPriority() + " This is child Thread");
	}
}

public class _05_ThreadPriorityDemo {

	public static void main(String[] args) {
	 System.out.println(Thread.currentThread().getPriority());
	 Thread.currentThread().setPriority(10);
	 System.out.println(Thread.currentThread().getPriority());
	 
	 ThreadPriority t = new ThreadPriority();
	 t.start();

	}

}
// 10=>priority>=1
//Window doesn't support Thread priorities .