package G_OOPS1.Generics;

import java.util.ArrayList;
import java.util.List;

public class B_ObjectVsWildCard1 {
    public static void main(String[] args) {
         /*
        ✅  What is Object in Java?
        Object is the parent class of all Java classes.
        It means any type of object can be stored in a variable of type Object.
          */

        Object obj1 = "Hello";     // String
        Object obj2 = 10;          // Integer
        Object obj3 = new ArrayList<>();  // List
        //But if you use obj1, you cannot use string methods directly (like obj1.length()) unless you cast it.

        /*
        * In Generic
        * */

        // Upcasting not possible in case of generics :
        List<Object> objectList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        //objectList = stringList;  // ❌ Error!

        //But why? Because Java does not allow assigning List<String> to List<Object>. Even though String is a subclass of Object, the generic types are not automatically compatible.

        // We can add anything
        // List<Object> allows add and get
        //List<Object> objectList = new ArrayList<>();
        objectList.add("Siddhesh");      // ✅ Add string
        objectList.add(10);              // ✅ Add integer
        Object name = objectList.get(0); // ✅ Read (type: Object)

        /*
        *
        * ✅  What is ? (Wildcard) in Java?
        ? means unknown type.
        It is used in generics, usually like this: List<?>
        You use ? when you don’t care about the exact type, but just want to say: “I accept some kind of object, but I don’t know which one.”
        * */

        // Upcasting anything

        List<?> list = new ArrayList<String>();
        //You can read items from this list (as Object), but you can't add anything to it (except null), because the type is unknown.

        //List<?> wildcardList = stringList;  // ✅ Works

        /*
        * Why it works?
        List<?> means: “A list of unknown type”
        So it can accept List<String>, List<Integer>, List<Double>, etc.
        * */

        // Doesnt allow add
        List<?> wildcardList = new ArrayList<String>();
        //wildcardList.add("Hello");   // ❌ Error
        wildcardList.add(null);        // ✅ Only null allowed
        Object item = wildcardList.get(0);  // ✅ You can read

        /*
        * you can't add anything (except null), because Java doesn't know the exact type.
        * You can read items, but they will come as Object.
        * */
    }
}
/*
🎯 Simple Real-World Example
Think of:

Object as a box that can hold anything, but you don’t know what’s inside unless you open it and check the type.

? as a locked mystery box. You can see what’s inside, but you can’t put anything into it, because you don’t know what type it accepts.



Exactly! ✅ You understood it perfectly!
Let me explain it clearly in simple English, related to Spring Boot and generics.

💡 Why ? is used in Spring Boot (like in ResponseEntity<?>)?
In Spring Boot controllers, you often see code like:


public ResponseEntity<?> getUser() {
    User user = new User("Siddhesh", 25);
    return ResponseEntity.ok(user);
}
Or even:

return ResponseEntity.ok(List.of(user1, user2));

✅ Why not use ResponseEntity<Object>?
Because Object is too strict in generics.

ResponseEntity<Object> res = ResponseEntity.ok(new ArrayList<String>()); // ❌ Error
Java will say: “List<String> is not the same as Object” (because List<String> ≠ Object, even if String extends Object)

✅ But ResponseEntity<?> means:
"ResponseEntity of some unknown type"

It allows any type — String, List, Map, DTO, etc.

So this works perfectly:

ResponseEntity<?> response = ResponseEntity.ok(new ArrayList<String>()); // ✅ OK
🔍 Reflection and ?
In Java Reflection or frameworks like Spring, we don’t always know the exact class/type in advance.

That’s why they use <?>, Class<?>, List<?>, etc.

Example:

Class<?> clazz = Class.forName("com.example.User");
This says: “We don’t know the type, but it’s some class.”

* */