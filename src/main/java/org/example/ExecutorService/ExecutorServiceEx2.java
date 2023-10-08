package org.example.ExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceEx2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit(newRunnable("T1"));

        System.out.println(future.isDone());

        try {
            future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
    private static Runnable newRunnable(String msg){
        return ()->{
            String completeMsg = Thread.currentThread().getName()+": "+msg;
            System.out.println(completeMsg);
        };
    }
}
