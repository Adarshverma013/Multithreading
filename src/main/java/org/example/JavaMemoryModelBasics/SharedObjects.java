package org.example.JavaMemoryModelBasics;

/**
 * Here count variable of MyRunnable will be shared between the two threads
 *
 * This condition where a variable is shared between two threads is called Race Condition.
 *
 * i variable will still not be shared as its a local variable and
 * each thread will have its own copy
 */
public class SharedObjects {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable,"Thread1");
        Thread t2 = new Thread(runnable,"Thread2");
        t1.start();
        t2.start();
    }
}
