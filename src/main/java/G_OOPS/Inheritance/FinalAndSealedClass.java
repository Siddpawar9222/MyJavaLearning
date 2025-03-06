package G_OOPS.Inheritance;

sealed class Human permits Manish,Vartika {
	public void printName() {
		System.out.println("Default");
	}
}
non-sealed class Manish extends Human {
	@Override
	public void printName() {
		 System.out.println("Manish Sharma");
	}
}
non-sealed class Vartika extends Human{
	@Override
	public void printName() {
		System.out.println("Varkita Pawar");
	}
}
final class Anjali {
	public void printName() {
		System.out.println("Anjali Sharma");
	}
}

public class FinalAndSealedClass {

	public static void main(String[] args) {
		
	}

}
// final -- restrict inheritance
// without final (extends) class , abstract -- we can extends it use the properties

//What if we want to restrict the number of classes that can inherit from a particular class? 

// --  a sealed class is a technique that limits the number of classes that can inherit the given class. 
//sealed - for parent class , non-sealed - for child class