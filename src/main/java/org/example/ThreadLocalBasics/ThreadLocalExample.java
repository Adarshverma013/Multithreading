package org.example.ThreadLocalBasics;

public class ThreadLocalExample {
    /**
     * It is designed to keep 1 value per thread
     */
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread t1 = new Thread(()->{
            threadLocal.set("Thread1");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            String value = threadLocal.get();
            System.out.println(value);
        });
        Thread t2 = new Thread(()->{
            threadLocal.set("Thread2");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            String value = threadLocal.get();
            System.out.println(value);
        });

        t1.start();
        t2.start();
        /**
         * 1. ThreadLocal has remove method to remove the value set by a thread
         *
         * 2. ThreadLocal can also be declared with an initial value
         */

        /**
         * 3. InheritableThreadLocal can share value to its child Thread
         */
        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        InheritableThreadLocal<String> threadLocal2 = new InheritableThreadLocal<>();

        Thread t3 = new Thread(()->{
            System.out.println("======Thread1=========");
            threadLocal1.set("Thread1 - ThreadLocal");
            threadLocal2.set("Thread2 - InheritableThreadLocal");

            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
            Thread childThread = new Thread(()->{
                System.out.println("=======Child Thread=======");
                System.out.println(threadLocal1.get()); // this will give NULL
                System.out.println(threadLocal2.get()); // this will give correct value as this gets inherited to child thread
            });
            childThread.start();
        });
        t3.start();
    }

}
