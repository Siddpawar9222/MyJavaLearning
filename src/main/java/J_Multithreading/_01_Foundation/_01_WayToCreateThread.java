package J_Multithreading._01_Foundation;

//Creating Multi-threading : thread class
class Task1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("This is Task1");
		}
	}
}

class Task2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("This is Task2");
		}
	}

}
class OneTask extends Thread{
	String name = "siddhesh" ;
	public OneTask(String name) {
		this.name= name ;
	}
	@Override
	public void run() {
	    for (int i = 0; i < 30; i++) {
			System.out.println("This is single Task from single Thread " + name);
		}
	}
}
public class _01_WayToCreateThread {

	public static void main(String[] args) {

		// Performing multiple tasks from multiple threads
		Task1 t1 = new Task1();
		Task2 t2 = new Task2();
		t1.start();
		t2.start();
		
		// Performing single tasks from multiple threads
		OneTask ot = new OneTask("Siddhesh");
		OneTask ot1 = new OneTask("Pawar");
		ot.start();
		ot1.start();

	}

}

//run() - It is used to do an action for a thread.
//start() - It is used to start the execution of the thread.
