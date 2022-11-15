package org.example.Volatile;

public class CounterMain {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(()->{
           while(counter.inc()){

           }
            System.out.println(counter.getCount());
        });

        Thread t2 = new Thread(()->{
            while(counter.inc()){

            }
            System.out.println(counter.getCount());
        });

        t1.start();
        t2.start();
    }
}
