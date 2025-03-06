package G_OOPS.Inheritance;
interface A {
    default void show() {
        System.out.println("show method executed from A");
    }
}

class B {
    public void show() {
        System.out.println("show method executed from B");
    }

    public final void finalShow() {
        System.out.println("finalShow method executed from B");
    }
}
public class InheritanceWithInterface extends B implements A {

    public static void main(String[] args) {
        InheritanceWithInterface inheritanceWithInterface = new InheritanceWithInterface();
        inheritanceWithInterface.show();
        inheritanceWithInterface.finalShow();
    }
}
/*
General Rule for Class Inheritance and Interface Implementation
- A class can extend only one class (Java does not support multiple inheritance with classes).
- A class can implement multiple interfaces.
The correct order is:
class ChildClass extends ParentClass implements Interface1, Interface2, ... { }

- Always use extends first (for class inheritance) and implements after (for interface implementation).
* */