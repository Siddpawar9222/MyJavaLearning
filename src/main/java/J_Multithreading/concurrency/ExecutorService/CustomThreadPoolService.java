package J_Multithreading.concurrency.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolService {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                5,
                0L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>(2),
                new ThreadPoolExecutor.CallerRunsPolicy() // rejection handler
        );

        for (int i = 0; i <= 9; i++) {
            int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}
/*
if i don't pass new ThreadPoolExecutor.CallerRunsPolicy() and
if queue is full, there will be is pending task is there then it gives error RejectedExecutionException
* */