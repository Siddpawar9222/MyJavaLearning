package J_Multithreading._01_Foundation._06_garbage_collector;

class MyObject {
    String name;

    public void doSomething() {
        System.out.println("Doing something....");
    }
}

public class _01_GarbageCollectionBasic {
    public static void main(String[] args) {
        // Create an object
        MyObject myObject = new MyObject();

        // Use the object
        myObject.doSomething();

        // Lose the reference (unreferenced)
        myObject = null;

        // You can't access myObject anymore

        // If you want to use the object again, you need to keep a reference
        myObject = new MyObject();
        myObject.doSomething(); // Now you can use it again

    }
}

/*
In Java, an object becomes eligible for garbage collection when it is no longer reachable or referenced by any live part of your program. The Java Garbage Collector identifies objects that are no longer in use and reclaims their memory to free up resources. Here are some common scenarios in which an object becomes eligible for garbage collection:

1. **Null References:** When you set all references to an object to `null`, meaning no variables or references point to the object.


   MyObject obj = new MyObject();
   obj = null; // Now, the obj is eligible for garbage collection.


2. **Method Scope:** When an object goes out of scope within a method, it becomes eligible. For example, if an object is created inside a method and the method exits, the object is no longer accessible.

   void someMethod() {
       MyObject obj = new MyObject();
       // obj is eligible for garbage collection when someMethod exits.
   }
 

3. **Object Reassignment:** If an object reference is reassigned to a different object, the original object is no longer reachable and becomes eligible.

   MyObject obj1 = new MyObject();
   MyObject obj2 = new MyObject();
   obj1 = obj2; // obj1 no longer refers to the original object.


4. **End of a Thread:** Objects local to a thread become eligible for garbage collection when the thread completes its execution.

5. **Closing Resources:** Objects that represent resources like file handles, database connections, or sockets should be explicitly closed. When you close such resources, the associated objects may become eligible for garbage collection.

6. **Circular References:** If a group of objects references each other in a circle, but none of them are reachable from outside the circle, they all become eligible for garbage collection. The garbage collector is smart enough to detect and collect circularly referenced objects.
 */
