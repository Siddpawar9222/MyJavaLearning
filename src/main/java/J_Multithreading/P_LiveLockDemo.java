package J_Multithreading;

public class P_LiveLockDemo {

    static volatile boolean personAOnLeft = true;
    static volatile boolean personBOnLeft = true;

    public static void main(String[] args) {

        Thread personA = new Thread(() -> {

            while (true) {

                if (personAOnLeft == personBOnLeft) {

                    System.out.println("A: You go first.");
                    personAOnLeft = !personAOnLeft;

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {}
                }
                else {
                    System.out.println("A Passed");
                    break;
                }
            }
        });

        Thread personB = new Thread(() -> {

            while (true) {

                if (personAOnLeft == personBOnLeft) {

                    System.out.println("B: No, you go first.");
                    personBOnLeft = !personBOnLeft;

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {}
                }
                else {
                    System.out.println("B Passed");
                    break;
                }
            }
        });

        personA.start();
        personB.start();
    }
}

/*
Classic Hallway Example
A and B are walking toward each other.

A sees B
A moves left

B sees A
B also moves left

Still blocked

A moves right

B also moves right

Still blocked

and

so on
* */
