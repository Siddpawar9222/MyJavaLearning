package J_Multithreading._08_Executor_Framework;

import java.util.concurrent.*;

public class _02_CustomThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,     //corePoolSize
                4,                // maximumPoolSize
                60,               // keepAliveTime for extra threads
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),  // queue with size 2
                new ThreadPoolExecutor.CallerRunsPolicy() // rejection handler
        );

        for (int i = 1; i <= 8; i++) {
            int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}