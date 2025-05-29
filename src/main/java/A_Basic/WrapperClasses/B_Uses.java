package A_Basic.WrapperClasses;

import java.util.ArrayList;

public class B_Uses {
    public static void main(String[] args) {
     /*
        Autoboxing = primitive → object automatically
     * */

        int a = 5;
        Integer obj = a; // Auto: int → Integer

        /*
        Unboxing = object → primitive automatically
     * */

        Integer obj1 = 20;
        int a1 = obj1; // Auto: Integer → int

        /*
        * Use :
        * */

        // To use primitives in collections (like ArrayList):
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); // works with Integer, not int

        //use null values:
        Integer k = null; // Object can be null, primitive can't

        // To use methods provided by wrapper classes
        int max = Integer.max(10, 20); // 20

    }
}