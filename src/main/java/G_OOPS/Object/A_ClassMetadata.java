package G_OOPS.Object;

public class A_ClassMetadata {

    public void getClassMetadata(){
        System.out.println(this.getClass().getClassLoader());
    }

    public static void main(String[] args) {
        System.out.println(A_ClassMetadata.class);
        A_ClassMetadata aClassMetadata = new A_ClassMetadata();
        System.out.println(aClassMetadata.getClass());
    }
}
/*
1. When to Use .class
✅ When you need the class metadata at compile-time.
✅ When you don’t have an object instance but still need to access class information.
✅ Mostly used in static contexts, annotations, and reflection.

Why .class?
We don't need an object to access it.
It’s faster because it resolves at compile-time.
Used in frameworks like Spring, Hibernate, and annotations.


2. When to Use obj.getClass()
✅ When you have an instance and need to get its class at runtime.
✅ Useful when working with polymorphism (e.g., checking the actual class of an object).
Why getClass()?
Used when you have an object and want to know its class at runtime.
Useful in logging, debugging, and reflection-based frameworks.


3. When to Use this.getClass()
✅ Refers to the current instance of the class.
✅ Used to access instance variables and methods inside the same class.
✅ Can be used with getClass() to get class metadata.
Why this.getClass()?
Used inside an instance method to get the class metadata dynamically.Cant use with static methods
Useful when working with inheritance to check the actual subclass type.
* */