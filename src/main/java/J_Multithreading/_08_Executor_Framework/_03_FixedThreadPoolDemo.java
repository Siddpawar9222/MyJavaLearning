package J_Multithreading._08_Executor_Framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _03_FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(2); // 2 threads
        for (int i = 0; i < 9; i++) {
            int taskId = i;
            fixedExecutorService.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        fixedExecutorService.shutdown();
    }
}
