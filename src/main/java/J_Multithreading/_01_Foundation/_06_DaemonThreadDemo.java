package J_Multithreading._01_Foundation;

class DT extends Thread{
	@Override
	public void run() {
		for(int i=0 ; i<200 ; i++) {
			System.out.println("Daemon Thread is running ... " + i);
		}
	}
}

public class _06_DaemonThreadDemo {

	public static void main(String[] args) {
		System.out.println("This is main Thread");
		System.out.println(Thread.currentThread().isDaemon());
		DT t = new DT();
		t.setDaemon(true);
		t.start();
		
		for(int i=0 ; i<20 ; i++) {
			System.out.println("Main Thread is running... " + i);
		}

	}

}
//As long as main thread is running daemon thread would run . Once main thread stop running(executing) daemon thread would dead 