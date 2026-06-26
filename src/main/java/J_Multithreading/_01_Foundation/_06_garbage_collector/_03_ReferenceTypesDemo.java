package J_Multithreading._01_Foundation._06_garbage_collector;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class _03_ReferenceTypesDemo {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();  //default type

        SoftReference<MyObject> softRef = new SoftReference<>(new MyObject());

         WeakReference<MyObject> weakRef = new WeakReference<>(new MyObject());

         ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
   PhantomReference<MyObject> phantomRef = new PhantomReference<>(new MyObject(), referenceQueue);
    }
}
/*
In Java, there are several types of references that define how objects are treated by the garbage collector and whether they can be reclaimed. These reference types help manage memory and control how objects are retained or released. The main types of references in Java are:

1. **Strong References:** This is the default type of reference in Java. When an object has one or more strong references pointing to it, the garbage collector will not collect it. These references are what you typically use in your code. For example:


   MyObject obj = new MyObject(); // Strong reference


2. **Soft References:** Soft references allow objects to be collected by the garbage collector if memory is running low. They are useful for implementing memory-sensitive caching. When the garbage collector runs out of memory, it will clear soft references.


   SoftReference<MyObject> softRef = new SoftReference<>(new MyObject());


3. **Weak References:** Weak references allow objects to be collected as soon as they become eligible for garbage collection. They are used for situations where you want the object to be reclaimed promptly when it's no longer strongly referenced.


   WeakReference<MyObject> weakRef = new WeakReference<>(new MyObject());


4. **Phantom References:** Phantom references are the weakest type of reference. They are used in conjunction with a `ReferenceQueue` and are typically used for clean-up or post-mortem operations. Once an object is phantom-reachable, it will be enqueued in the reference queue, allowing you to perform cleanup actions.

   ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
   PhantomReference<MyObject> phantomRef = new PhantomReference<>(new MyObject(), referenceQueue);

 */