package G_OOPS.Inheritance.Constructor;

//1. Order of execution of constructor in Single inheritance

//In single level inheritance, the constructor of the base class is executed first.

//--------------------------------

//2. Order of execution of constructor in Multilevel inheritance

//In multilevel inheritance, all the upper class constructors are executed when an instance of bottom most child class is created.


class ParentClass   
{  
      
    ParentClass()  
    {  
        System.out.println("ParentClass constructor executed.");  
    }  
    
}  
  
 
class ChildClass extends ParentClass   
{   
    ChildClass()  
    {  
        System.out.println("ChildClass constructor executed.");  
    }  
}  


public class InheritanceWithConstructor {
     public static void main(String[] args) {
		ChildClass cc = new ChildClass();
	}
}
