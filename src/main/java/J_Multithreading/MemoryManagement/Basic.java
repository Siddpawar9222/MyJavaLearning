package J_Multithreading.MemoryManagement;

import java.lang.reflect.Field;
class Demo {
    static int count = 10;   // static variable
    int id = 5;              // instance variable
}

public class Basic {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // Get the Class object of Demo
        Class<?> clazz = Demo.class;

        // Print all declared fields of Demo
        System.out.println("Declared fields of Demo:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("  " + field);
        }

        // Access the static variable 'count' using Class object
        Field countField = clazz.getDeclaredField("count");
        System.out.println("\nValue of static variable count: " + countField.get(null));

        // Access instance variable 'id' using an object
        //Demo d1 = new Demo();
        Field idField = clazz.getDeclaredField("id");
        System.out.println("Value of instance variable id (from d1): " + idField.get(null));
    }
}
