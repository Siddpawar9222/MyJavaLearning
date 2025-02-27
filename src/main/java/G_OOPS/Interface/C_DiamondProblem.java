package G_OOPS.Interface;


interface A {

    default void doSomething() {
        System.out.println("A's doing something");
    }
}

interface B extends A {

    @Override
    default void doSomething() {
        System.out.println("B's doing something");
    }
}

interface C extends A {

    @Override
    default void doSomething() {
        System.out.println("C's doing something");
    }
}

//class D  implements B , C{ }     //compilation error


class D implements B, C {

    // provided custom implementation
//     @Override
//     public void doSomething(){
//            System.out.println("D's doing something");
//     }

    // Lets suppose i want to call either B's or C's or both
    @Override
    public void doSomething() {
        B.super.doSomething();
        C.super.doSomething();
    }


}


public class C_DiamondProblem {
    public static void main(String[] args) {
        A d = new D();
        d.doSomething();
    }
}


/*
Problem :
- Both B and C are implementing A and has same method doSomething(). if D class implements both B and C then it will give compilation error because compiler does not know which method should be used(compiler is confused here).
-  If either B or C would not have same method doSomething() then D class would not given that compilation error.

Solution :
A] Using default method :
- We know that default method is not necessary(compulsory) to implement in subclass.
- So we have choice to call
     - B's or C's or both doSomething() methods using super keyword
     - Provide custom implementation of doSomething() method in D class.

B] Using normal abstract method :
- We can use normal abstract method
- We have here only one choice :
     - Provide custom implementation of doSomething() method in D class as abstract method doesn't have any body(implementation).
*/