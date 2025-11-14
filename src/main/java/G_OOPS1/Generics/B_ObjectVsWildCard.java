package G_OOPS1.Generics;

import java.util.ArrayList;

public class B_ObjectVsWildCard {
    public static void main(String[] args) {

        /*
         * Without Generics
         * */

        // Object is the parent class of all classes in Java.


        Object obj1 = "Hello";
        Object obj2 = 10;
        Object obj3 = new ArrayList<>();

        // You can store anything in Object. But if you want to use specific methods, you have to cast it.

        Object str = "Siddhesh";
        //System.out.println(str.length());  // ❌ Error
        System.out.println(((String) str).length());  // ✅ OK

        /*
        * So:
         ✅ Object is a real class.
         ✅ It is used without generics all the time.
         ❌ But it has no connection to ? directly.
        * */


        /*
        *🔸 ? is only used with generics
        You cannot use ? like this:
        ? anything = "Hello";   // ❌ Invalid - compile error
        ⚠️ ? is not a type by itself. It only makes sense inside generics like:
        List<?>
        Map<String, ?>
        ResponseEntity<?>
        Class<?>
        * */
    }
}
