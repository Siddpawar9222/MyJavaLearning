package M_Java8.A_LambdaExp;

@FunctionalInterface
interface Drawable {
    void draw();
}

@FunctionalInterface
interface Concat {
    String concat(String s1, String s2);
}

public class Example01 {

    public static void main(String[] args) {

        //Anonymous function
        Drawable d = new Drawable() {
            @Override
            public void draw() {
                System.out.println("This is anonymous class implementation.");
            }
        };
        d.draw(); // *

        //Lambda function
        Drawable lambda = () -> {
            System.out.println("This is Lambada Expression.");
        };
        lambda.draw();

        Concat lambda1 = (s1, s2) -> s1 + s2;
        System.out.println(lambda1.concat("Siddhesh", "pawar"));

       // Predefined Functional Interface
        Runnable runnable = () -> {
            for (int i = 0; i < 11; i++) {
                try {
                    System.out.println(i + " ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
    }

}

/*
 // * --> To provides a clear and concise way to represent one method interface using an expression, We can use Lambda expression(enhancement of anonymous implementation).
 */