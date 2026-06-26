package J_Multithreading._01_Foundation;

class VLC extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("vlc playing");
		System.out.println(Thread.currentThread().getName());
	}
}

public class _04_ThreadMethods {

	public static void main(String[] args) {
	
		  /* 
		  System.out.println("Hello");
		  System.out.println(Thread.currentThread().getName());
		  Thread.currentThread().setName("siddhesh"); // *
		  System.out.println(Thread.currentThread().getName()); 
		  System.out.println(10 / 0);
		  */
		 
		VLC v = new VLC();
		// v.setName("VLC Playing again");
		v.start();
		System.out.println(v.isAlive());
		System.out.println("State is " + v.getState());

	}

}
//*--> I can change the name of main thread too