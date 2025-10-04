package J_Multithreading;

class MedicalTest extends Thread {
	Thread mainThread;

	public MedicalTest(Thread mainThread) {
		this.mainThread = mainThread;
	}

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {

			try {
				//mainThread.join(); // Until main thread not executing completely wait for thread-0
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Medical Test ending in " + i + " sec");

		}

	}
}

public class H_ThreadJoin {

	public static void main(String[] args) {

		MedicalTest mt = new MedicalTest(Thread.currentThread());
		mt.start();

		for (int i = 10; i > 0; i--) {

			try {
				 mt.join(); //Until thread-0(mt) not executing completely wait for main thread
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Driving Test ending in " + i + " sec");

		}

	}

}
/*
*definite wait, used when one thread must finish before another continues.(dependency task)
* */