package org.example.JavaMemoryModelBasics;

public class MyRunnable implements Runnable{

    private int count = 0;

    @Override
    public void run() {
        /**
         * Each thread will have its own copy and own object in the heap
         * in both shared and seperate cases as its a local variable of a thread
         */
        Object o1 = new Object();
        System.out.println("Object: "+o1);
        for(int i = 0;i < 1_000_000;i++){
            this.count++;

            /**
             * This code sample is to remove the race condition by synchronization
             *
             */
//            synchronized (this){
//                this.count++;
//            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+this.count);
    }
}
