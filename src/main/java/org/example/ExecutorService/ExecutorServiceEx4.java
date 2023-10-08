package org.example.ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceEx4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(newCallable("T1"));
        callableList.add(newCallable("T2"));
        callableList.add(newCallable("T3"));
        callableList.add(newCallable("T4"));


        try {
            String result = (String)executorService.invokeAny(callableList);
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------------------------------------------");

        try {
            List<Future<String>> results = executorService.invokeAll(callableList);
            results.forEach((future)-> {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (InterruptedException e) {
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
