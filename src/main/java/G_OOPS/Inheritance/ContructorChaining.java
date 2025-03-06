package G_OOPS.Inheritance;

//Constructor chaining in Java 
//To call one constructor from another constructor is called constructor chaining in java. This process can be implemented in two ways:
//Using this() keyword to call the current class constructor within the “same class”.
//Using super() keyword to call the superclass constructor from the “base class”.
//In Java programming, constructor chaining is used where we want to perform multiple tasks in a separate constructor for each task and make their order by chaining. This technique makes the program more readable and easy to understand for everyone.
//We can provide as many constructors as we want within the class and use constructor chaining to set the link among them.

class GrandParent{
	public GrandParent() {
		System.out.println("Default(0 Para) Grandparent constructor........");
	 }
	public GrandParent(String name ,int id ) {
		System.out.println("2 para  Grandparent constructor........" + name + " "+id);
	}
}

class Parent extends GrandParent{
	public Parent() {
		System.out.println("Default(0 Para) parent constructor........");
	 }
	public Parent(String name ,int id ) {
		System.out.println("2 para  parent constructor........" + name + " "+id);
	}
	
}
class Child extends Parent{
	public Child() {
		System.out.println("Default(0 Para) child constructor........");
	}
	public Child(String name ,int id) {
		super("Pawar" ,22);
		System.out.println("2 para  Child constructor........" + name + " "+id);
	}
}


public class ContructorChaining {
            ContructorChaining(){
                this("siddhesh",22);
            	System.out.println("This is default constructor....");
             }
            ContructorChaining(String name){
            	System.out.println("This is one para constructor "+ name);
            }
            ContructorChaining(String name , int id){
            	this("Bappa");
            	System.out.println("This is two para constructor "+ name + " " +id);
            }
            
            public static void main(String[] args) {
			   	ContructorChaining a = new ContructorChaining();
			//-----------------------------------------//
				 //Child cc = new Child();
				//Child cc1 = new Child("Siddhesh", 545);
			}
}

//The super keyword is used to represent an instance of the parent class which is created implicitly for each object of the child class. The super keyword can be used to invoke the parent class methods and constructors. It can also be used to access the fields of the parent class.


//The this keyword is used to represent the current instance of a class. It is used to access the instance variables and invoke current class methods and constructors. The this keyword can be passed as an argument to a method call representing the current class instance.
