package J_Multithreading;

public class P_DeadLockSolution {
  public static void main(String[] args) {

		Object pen1 = new Object();
		Object pen2 = new Object();

		Thread personA = new Thread(() -> {
			synchronized (pen1) {
				System.out.println("Person A picked up pen 1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (pen2) {
					System.out.println("Person A picked up pen 2");
				}
			}
		});

		Thread personB = new Thread(() -> {
			synchronized (pen1) {
				System.out.println("Person B picked up pen 1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (pen2) {
					System.out.println("Person B picked up pen 2");
				}
			}
		});
       
		personA.start();
		personB.start();
}
}
//changing the order of the locks prevent the program in going into a deadlock situation.