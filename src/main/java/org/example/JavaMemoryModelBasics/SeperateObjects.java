package org.example.JavaMemoryModelBasics;

/**
 * Here in heap there will be 2 Runnable objects
 * so there will be 2 seperate count values in the heap
 */
public class SeperateObjects {
    public static void main(String[] args) {
        MyRunnable runnable1 = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();

        Thread thread1 = new Thread(runnable1,"Thread1");
        Thread thread2 = new Thread(runnable2,"Thread2");
        thread1.start();
        thread2.start();
    }
}
