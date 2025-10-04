package J_Multithreading;

class SleepThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 11; i++) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);

		}
	}

}

public class F_SleepThread {

	public static void main(String[] args) {
		SleepThread st = new SleepThread();
		st.start();

//		for(int i=0 ; i<20 ; i++) {
//			System.out.println("Main Thread is running... " + i);
//		}

		// ========================================================//

		Runnable sleep1 = () -> {
			for (int i = 0; i < 11; i++) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i + " : " + Thread.currentThread().getName());

			}

		};

		Runnable sleep2 = () -> {
			for (int i = 0; i < 11; i++) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i + " : " + Thread.currentThread().getName());

			}

		};

		Thread t1 = new Thread(sleep1);
		Thread t2 = new Thread(sleep2);
		t1.start();
		t2.start();

//		t1.run();   //Here we didn't create thread . This creates methods
//		t2.run();

	}

}

//The method sleep() is being used to halt/pause the working of a thread for a given amount of time.