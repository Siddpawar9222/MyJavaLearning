package J_Multithreading.concurrency._10Semaphore;

import java.util.concurrent.Semaphore;

public class _02_ParkingLot {

    private static final Semaphore semaphore =
            new Semaphore(3,true);  // default is non-fair

    public static void parkCar(String carName) {

        try {
            System.out.println(carName + " waiting");

            semaphore.acquire();

            System.out.println(
                    carName + " entered parking");

            Thread.sleep(5000);

            System.out.println(
                    carName + " leaving parking");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            int id = i;

            new Thread(() ->
                    parkCar("Car-" + id)
            ).start();
        }
    }
}
