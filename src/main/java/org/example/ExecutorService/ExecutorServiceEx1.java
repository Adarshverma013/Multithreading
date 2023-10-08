package org.example.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceEx1 {
    public static void main(String[] args) {
        // Factory method to create instance
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(newRunnable("Task1"));
        executorService.execute(newRunnable("Task2"));
        executorService.execute(newRunnable("Task3"));
        executorService.execute(newRunnable("Task4"));
        executorService.execute(newRunnable("Task5"));
        executorService.execute(newRunnable("Task6"));

        executorService.shutdown();

        int corePoolSize = 10;
        int maxPoolSize = 20;
        long keepAliveTime = 3000;

        // Builtin Implementations
        ExecutorService threadPoolExecutor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                       TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<>(128)
                );

        ScheduledExecutorService scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(corePoolSize);
    }

    private static Runnable newRunnable(String msg){
        return ()->{
          String completeMsg = Thread.currentThread().getName()+": "+msg;
            System.out.println(completeMsg);
        };
    }
}
