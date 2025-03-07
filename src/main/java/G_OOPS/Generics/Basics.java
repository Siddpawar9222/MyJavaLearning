package G_OOPS.Generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    // For static method
    public static <T> List<T> createList(T... elements) {
        List<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    // For non-static method
    public Set<T> createSet(T... elements) {
        Set<T> list = new HashSet<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    //Without Generics (This class Box1 bounded to only String type object(datatype))
    class Box1 {
        private String value;

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    class Box2 {
        private Object value;

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }

    public class Basics {
        public static void main(String[] args) {


            // Box2 intBox = new Box2();
            // intBox.setValue(42);
            // int value = (int) intBox.getValue(); // Type casting required, type safety not guaranteed


            Box<String> stringBox = new Box<>();
            stringBox.setValue("Hello, world!");
            System.out.println(stringBox.getValue());
            //stringBox.setValue(456);              //It wont works of integer only for String data type

            //similary we can use here integer data type

            List<String> list = Box.createList("Hello", "World", "New", "York");
            System.out.println(list);

        }
    }
}

/*

Generics are a feature of Java that allow you to write code that is more type-safe and reusable.

Benefits :
-Type safety: Generics help to ensure that your code is type-safe. This means that you can be confident that the code will work correctly, even if you change the types of the objects that you are working with.
-Reusability: Generics make your code more reusable. This is because you can write generic classes and methods that can work with any type of object. This can save you a lot of time and effort, especially if you are working with a lot of different types of objects.
-Ease of use: Generics make your code easier to use. This is because you do not have to worry about casting objects or dealing with type errors.
 */