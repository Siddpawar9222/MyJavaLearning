package G_OOPS.NestedClasses;

class InnerClass {
    private int data = 30;// instance variable

    void display() {
        int value=50;
        class Local {
            void msg() {
                System.out.println(value);
            }
        }
        Local l = new Local();
        l.msg();
    }
}

public class C_LocalInnerClass {
    public static void main(String[] args) {
         InnerClass i = new InnerClass();
         i.display();
    }
}

/*
local inner class :
//- A class i.e., created inside a method, is called local inner class in java. Local Inner Classes are the inner classes that are defined inside a block. Generally, this block is a method body. Sometimes this block can be a for loop, or an if clause.
- They belong to the block they are defined within, due to which local inner classes cannot have any access modifiers associated with them. However, they can be marked as final or abstract. 

Rules :
1) Local inner class cannot be invoked from outside the method.
2) Local inner class cannot access non-final local variable till JDK 1.7. Since JDK 1.8, it is possible to access the non-final local variable in the local inner class.
 */