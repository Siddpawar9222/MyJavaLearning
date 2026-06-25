package J_Multithreading._01_Foundation;

//Creating Multi-threading : Runnable interface(Better way)
class Task3 implements Runnable {

	@Override
		public void run() {
			for (int i = 0; i < 30; i++) {
				System.out.println("This is Task3");
			}
		}
	}

class Task4 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("This is Task4");
		}
	}

}

public class _02_RunnableThreadCreation {    //By default thread

	public static void main(String[] args) {
		
/*		
		Task3 t3 = new Task3();
		Thread th3 = new Thread(t3);
		th3.start();
		
		Task4 t4 = new Task4();
		Thread th4 = new Thread(t4);
		th4.start();
		
*/	
	
       //Using lambda expression		
		Runnable t5 = ()->{
			for (int i = 0; i < 30; i++) {
				System.out.println("This is Task5");
			}  
		};
		
		Runnable t6 = ()->{
			for (int i = 0; i < 30; i++) {
				System.out.println("This is Task6");
			}  
		};
		
		Thread th5 = new Thread(t5);
		Thread th6 = new Thread(t6);
		th5.start();
		System.out.println("Hello 1");
		th6.start();
		System.out.println("Hello 2");   //*
		
		

	}

}
// * --> Here we implement Multithreading in our program . when we called th5.start(); By the time this being called  Hello 1 is executed immediately . same for th6 too .