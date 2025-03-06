package G_OOPS.Inheritance.Constructor;

class Animal   
{  
      
    Animal()
    {
        System.out.println("ParentClass constructor with 0 parameter executed.");
    }
    
    Animal(String name){
    	System.out.println("ParentClass constructor with one parameter is executed " + name);
    }
}  
  
 
class Cat extends Animal   
{   
    Cat()  
    {  
        System.out.println("ChildClass constructor with 0 parameter executed.");  
    }  
    Cat(String name){
    	super("koko") ;
    	System.out.println("ChildClass constructor with one parameter is executed " + name);
    }
}

// class Dog extends Cat{
// 	Dog()  
//    {  
//        System.out.println("ChildClass constructor with 0 parameter executed.");  
//    }  
//    Dog(String name){
//     super("Mayee");
//    	System.out.println("ChildClass constructor with one parameter is executed " + name);
//    }
// }


public class InheritanceWithConstructor1 {
     public static void main(String[] args) {
    	 //Cat cc = new Cat();          //Parent class constructor with zero parameter will be executed first and then Child classes constructor will called sequentially.
		Cat cc = new Cat("Bokeyy");  //Same here parent class constructor with zero parameter will execute first  then child class constructor will be executed
   	     
 // If there is no constructor with zero parameter in parent class 
    	 //case1 - if class is empty --> default constructor(invisible to us) will call
    	 //case2 - if class having parameter constructor ---> Compilation error
    

	}
}