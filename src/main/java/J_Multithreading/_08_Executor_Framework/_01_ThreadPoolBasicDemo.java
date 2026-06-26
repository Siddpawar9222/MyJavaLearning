package J_Multithreading._08_Executor_Framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _01_ThreadPoolBasicDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		for (int i = 1; i <= 10; i++) {
			final int taskNum = i;
			executorService.submit(() -> {
				System.out.println("Task " + taskNum + " executed by thread: " + Thread.currentThread().getName());
			});
		}

		executorService.shutdown();

	}

}
/*
Imagine you have a group of workers available to perform tasks for you. Instead of hiring and firing workers for each individual task, you create a pool of workers in advance. These workers are ready and waiting to take on tasks whenever needed.

When you have a task that needs to be done, you submit it to the pool. One of the available workers picks up the task and starts working on it. If all workers are currently busy, the task waits in a queue until a worker becomes available.

Once a worker finishes a task, it can immediately pick up another task from the queue. This way, the workers are kept busy, and tasks are processed efficiently without wasting time creating and destroying workers for each task.

Using a thread pool in Java is like having a team of workers ready to handle tasks, making the processing of multiple tasks more organized and efficient.
*/