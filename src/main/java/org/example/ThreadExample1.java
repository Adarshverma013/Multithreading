package org.example;

public class ThreadExample1 {
    public static class MyRunnableClass implements Runnable{

        @Override
        public void run() {
            System.out.println("Runnable interface implementation of thread");
        }
    }
    public static class MyThreadClass extends Thread{
        @Override
        public void run() {
            System.out.println("Thread implementation by extending Thread class");
        }
    }
    public static void main(String[] args) {
        /**
         * There are two ways to create a thread,
         * 1. By extending the Thread class
         * 2. By implementing the Runnable Interface and passing its object in constructor of Thread class
         */
        MyThreadClass t1 = new MyThreadClass();
        t1.start();

        Thread t2 = new Thread(new MyRunnableClass());
        t2.start();
        // Anonymous class implementation
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                String ThreadName = Thread.currentThread().getName();
                System.out.println("Anonymous Runnable interface implementation of thread "+ThreadName);
            }
        };
        Thread t3 = new Thread(runnable,"My Thread");
        t3.start();
        Thread t4 = new Thread(()->{
            System.out.println("Lambda expression implementation");
        });
        t4.start();
    }
}
