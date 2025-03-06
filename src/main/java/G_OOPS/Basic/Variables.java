package G_OOPS.Basic;

class First {
	int a; // Instance Variable
	int b;

	public void fun() {
		String nameString = "Hello" ;        //local variable
		System.out.println("This is class " + nameString);
	}

}

public class Variables {
	// int a ; //I cant aceess to main method
	static int a1 = 10;     //We cant change it 

	public static void main(String[] args) {
//		   System.out.println(a1); 

		// To Access Instance variable
		First f1 = new First();
		First f2 = new First();

		System.out.println(f1.a);
		System.out.println(f1.b);
		f1.a = 10;
		f1.b = 20;
		System.out.println(f1.a);
		System.out.println(f1.b);
		System.out.println(f2.b);
		System.out.println(f2.b);

		System.out.println(a1);
        
		f1.fun();
	}
}
