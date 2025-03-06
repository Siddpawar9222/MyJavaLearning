package G_OOPS.Polymorphism.DynamicMethodDispatch;

class A{
    public void name() {
		System.out.println("In the A");
	}
}

class B extends A{
	@Override
	public void name() {
		System.out.println("In the B");
	}
}
class C extends B{
	@Override
	public void name() {
		System.out.println("In the C");
	}
	
	public void place() {
		System.out.println("In baramati");
	}
}

class D {}

public class DMD {

	public static void main(String[] args) {
		
		A obj = new A() ;
		obj.name();
		
        obj= new B() ;
        obj.name() ;
		
		obj =new C();
		obj.name();
	    //obj.place() ; //*
		
	   //obj = new D(); //**
	}

}


/*
-We have same object reference obj and we are changing the type of objects and we are getting different  result(behavior) which is called as runtime polymorphism .
In short i come to know that Which method will call only if i run this program(At runtime)
This is also known as Dynamic Method Dispatch

-Runtime polymorphism provides flexibility and extensibility in object-oriented programming by allowing different behaviors to be achieved through method overriding. It enables code to be written based on the abstract or general class/interface types, while the actual behavior is determined by the specific object types at runtime. This facilitates code reuse, abstraction, and flexibility in object-oriented designs.

**-->Only applicable when inheritance(inherited class / interface ) is there

*--> IMP :  In Java, when you assign an object of a subclass to a reference of a superclass/interface, you can only access the methods and members that are declared in the superclass/interface. 
 */ 

 /*
  Virtual functions :
  -In object-oriented programming, especially in languages like C++, the term "virtual functions" refers to a mechanism that allows a subclass to provide its own implementation of a method defined in a superclass. This concept is used to achieve dynamic polymorphism .
  -Java supports the concept of virtual functions through its implementation of method overriding. In Java, all non-static methods and non-private are considered to be "virtual" by default, which means that they can be overridden in subclasses to provide a different implementation.
  -It's important to note that not all programming languages use the term "virtual functions," and the concept may be implemented differently in different languages. C++ is a language that explicitly uses the term "virtual functions" and provides specific syntax (virtual keyword) to enable this feature.
*/
