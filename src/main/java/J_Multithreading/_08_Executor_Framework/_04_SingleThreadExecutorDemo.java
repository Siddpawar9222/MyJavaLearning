package J_Multithreading._08_Executor_Framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _04_SingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            });
        }

        executor.shutdown();
    }
}
