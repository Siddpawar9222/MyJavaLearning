//In Java, access modifiers are keywords used to determine the accessibility of classes, methods, and fields. There are four access modifiers in Java: public, private, protected, and default (sometimes called "package-private").

//The public access modifier has the widest scope among all other access modifiers.

//Classes, methods, or data members that are declared as public are accessible from everywhere in the program. There is no restriction on the scope of public data members.


package G_OOPS.AccessModifiers;

//import G_OOPS.Access_Modifiers.Default.DefaultAMClass;

 import G_OOPS.AccessModifiers.Protected.Person;


//Default 

//public class Test {
//	public static void main(String[] args) {
////		DefaultAMClass am = new DefaultAMClass();   
//		// I can't use default access modifier outside the package  
//	}
//}

//protected
public class Test extends Person {
	public static void main(String[] args) {
		 
		Person p = new Person();
		//System.out.println(p.name); //I can't access this name
		
		Test t  = new Test();
		System.out.println(t.name + " " + t.age);
		t.printDetails() ;
	}
}