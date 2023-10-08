package org.example.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceEx3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit(newCallable("T1"));

        System.out.println(future.isDone());

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
    private static Callable newCallable(String msg){
        return ()->{
            String completeMsg = Thread.currentThread().getName()+": "+msg;
            return completeMsg;
        };
    }
}
