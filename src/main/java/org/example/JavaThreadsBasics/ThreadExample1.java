package org.example.JavaThreadsBasics;

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
         */
        MyThreadClass t1 = new MyThreadClass();
        t1.start();

        /**
         * 2. By implementing the Runnable Interface and passing its object in constructor of Thread class
         */
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
        /**
         * JVM will stay alive until a thread is running
         * if the thread is Daemon then JVM will terminate the Daemon thread before terminating the main thread
         * thread.join() can be used for one thread to wait for the other thread to terminate
         *
         */
    }
}
