package G_OOPS.Interface;

interface Vehicle {
    String color = "blue";

    void start();

    void accelerate();

    void brake();

    String numberplate();

    //since java 8 (default and static methods allowed)
    default void stop() {
        performOperation();
        System.out.println("Vehicle Stopped");
    }

    static void repair() {
        System.out.println("Vehicle repaired.");
    }

    //since java 9 (private methods are allowed)
    private void performOperation() {
        System.out.println("Performing operation.");
    }
}

class Bicycle implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bicycle started");
    }

    @Override
    public void accelerate() {
        System.out.println("Bicycle Accelerate");
    }

    @Override
    public void brake() {
        System.out.println("Bicycle braked");
    }

    @Override
    public String numberplate() {
        return "MH-42 92222";
    }

}
//similary for car and Bike

public class A_Basic {
    public static void main(String[] args) {
        Vehicle.repair();
        Vehicle b = new Bicycle();

    }
}

/*
In simple language, an interface in Java is like a contract or a set of rules that a class can must agree to follow. It defines a list of methods that a class must implement if it wants to adhere to that interface. it is typically used as a blueprint for other classes to inherit from.

It's like saying, "If you want to be a part of this group or have a certain role, you need to have these specific methods."



Why interface ? 
acheive abstraction ,functionality of multiple inheritance, acheive loose coupling
strict contract

Points to remember :

interface can be only default or public Access Modifiers just like class
it cannot be instantiated just like the abstract class.
cannot have constructor

By default(Internal addition by the compiler)
    String color = "blue" ; ---> public static final String color = "blue" ;
    void start() ;         --->  public abstract void start();
    
since java 8 (default and static methods allowed) :
**default methods :
  - The purpose of default methods is to allow adding new methods to an existing interface  without breaking the implementation of classes that already implement that interface.
  - Default methods can be overridden by the implementing classes if they choose to provide their own implementation.   
 
**static methods :
  - provide utility methods or helper methods related to the interface.
  - Belongs to interface
  - cannot be overridden by implementing classes.
  -These methods can be called using the interface name, without creating an  instance of the interface.( Vehicle.repair();)

since java 9 (private methods are allowed)  
   -Private methods used to break down complex logic into smaller reusable components within the interface. They help improve code organization and readability(encapsulate implementation).
*/