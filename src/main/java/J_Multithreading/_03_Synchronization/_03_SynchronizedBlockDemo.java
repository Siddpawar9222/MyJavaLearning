package J_Multithreading._03_Synchronization;

class Table3 {
	void printTable3(int n) {
		System.out.println("#########Start######### " + n);
		System.out.println("#########Start######### " + n); // thousand line of code
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 
		System.out.println("#########Start######### " + n); 

		synchronized(this){

			for (int i = 1; i <= 10; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		System.out.println("#########End######### "+n);
		System.out.println("#########End######### "+n);
		System.out.println("#########End######### "+n);
		System.out.println("#########End######### "+n);
		System.out.println("#########End######### "+n);
		System.out.println("#########End######### "+n);
		System.out.println("#########End######### "+n);
		System.out.println("#########End######### "+n);
		System.out.println("#########End######### "+n);
		System.out.println("#########End######### "+n);

		System.out.println();

	}
}

class MyThread5 extends Thread {
	Table3 t;

	MyThread5(Table3 t) {
		this.t = t;
	}

	public void run() {
		t.printTable3(2);
	}

}

class MyThread6 extends Thread {
	Table3 t;

	MyThread6(Table3 t) {
		this.t = t;
	}

	public void run() {
		t.printTable3(6);
	}
}

public class _03_SynchronizedBlockDemo {
	public static void main(String args[]) {
		Table3 obj = new Table3(); // only one object
		MyThread5 t1 = new MyThread5(obj);
		MyThread6 t2 = new MyThread6(obj);
		t1.start();
		t2.start();
	}
}
//Synchronized block can be used to perform synchronization on any specific(Block of code) resource of the method.

//Suppose we have 50 lines of code in our method, but we want to synchronize only 5 lines, in such cases, we can use synchronized block.
//
//If we put all the codes of the method in the synchronized block, it will work same as the synchronized method.