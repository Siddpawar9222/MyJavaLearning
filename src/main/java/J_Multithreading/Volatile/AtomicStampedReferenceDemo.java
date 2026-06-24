package J_Multithreading.Volatile;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {

    public static void main(String[] args)
            throws InterruptedException {

        AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 1);

        Thread t1 = new Thread(() -> {

            int[] stampHolder = new int[1];

            String value = ref.get(stampHolder);   //1

            int stamp = stampHolder[0];

            System.out.println(
                    "T1 Read -> Value="
                            + value
                            + ", Stamp="
                            + stamp
            );

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }

            boolean success = ref.compareAndSet("A", "C",
                    stamp, stamp + 1
            );

            System.out.println(
                    "T1 CAS Result = "
                            + success
            );

        });

        Thread t2 = new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

            int currentStamp = ref.getStamp();

            ref.compareAndSet("A", "B",
                    currentStamp, currentStamp + 1
            );

            System.out.println(
                    "T2 Changed A -> B"
            );

            currentStamp = ref.getStamp();

            ref.compareAndSet(
                    "B", "A",
                    currentStamp, currentStamp + 1
            );

            System.out.println("T2 Changed B -> A");

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
                "\nFinal Value = "
                        + ref.getReference()
        );

        System.out.println(
                "Final Stamp = "
                        + ref.getStamp()
        );
    }
}

/*


AtomicStampedReference
    = Reference + Version Number
    = Used to detect ABA problem

AtomicMarkableReference
    = Reference + Boolean Flag
    = Used for logical deletion / active-inactive state


1] Why array :
   AtomicStampedReference stores Reference + Stamp like
   private volatile Pair<V> pair;

   private static class Pair<T> {
        final T reference;
        final int stamp;
        private Pair(T reference, int stamp) {
            this.reference = reference;
            this.stamp = stamp;
        }
        static <T> Pair<T> of(T reference, int stamp) {
            return new Pair<T>(reference, stamp);
        }
    }

     If we use methods

     public V getReference() {
        return pair.reference;
     }

       public int getStamp() {
        return pair.stamp;
       }

     Although we can get reference and stamp separately, but we cannot get them atomically. Between this two reads multiple threads might have changed  value and we might not get right pair.

   public V get(int[] stampHolder) {
        Pair<V> pair = this.pair;
        stampHolder[0] = pair.stamp;
        return pair.reference;
    }

    That's why we used above method
* */