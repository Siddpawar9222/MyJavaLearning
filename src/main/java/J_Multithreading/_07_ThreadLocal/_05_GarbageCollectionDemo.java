package J_Multithreading._07_ThreadLocal;

class Cricketer{
    public Cricketer(){
        System.out.println("Object is Created....");
    }
    @Override
    protected void finalize() throws Throwable {
      System.out.println("Object is Destroyed...");
    }
}
public class _05_GarbageCollectionDemo {
    public static void main(String[] args) throws Throwable {
         Cricketer c = new Cricketer();
         c = null ; // 1.By assigning a null
        System.gc();

        //  Cricketer c1 = new Cricketer();
        //  Cricketer c2 = new Cricketer();
        //  c1=c2 ;  //2 .Reference to other another
        //  System.gc();
         
        // new Cricketer(); //3.By anonymous object
        // System.gc();
        
    }
}
/*
Eligibility Criteria for Garbage Collection in Java :
1.By assigning a null
2.Reference to other another
3.By anonymous object


gc() : static method in System and Runtime class
finalize() : method in object. this method invoked each time before the object is garbage collected.

When we run System.gc() we're suggesting to the Java Virtual Machine (JVM) that it should run the garbage collector .and then GC which invoke finalize method.
However, it's important to note that calling gc() doesn't guarantee immediate garbage collection. The JVM may choose to ignore the request or run garbage collection at its own discretion.

GC is automatic process in java done by jvm .


it's important to note that the finalize() method is considered deprecated since Java 9, and its use is discouraged due to its unpredictable behavior and performance implications.


Why Java Had Gave gc() and finalize method since GC is being automatic process  ?
-Gives developers a way to release any resources or perform any necessary cleanup tasks associated with an object before it is removed from memory. 
- manual intervention for garbage collection is deemed necessary, although it's typically not recommended to rely heavily on manual garbage collection calls.

Modern Java achieves efficient garbage collection without relying on the finalize() method by leveraging advanced algorithms, concurrent collection techniques, and configurable options provided by the JVM. This approach improves memory management, reduces pause times, and enhances overall application performance.

 */