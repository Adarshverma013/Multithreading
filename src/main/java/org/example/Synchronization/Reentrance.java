package org.example.Synchronization;

public class Reentrance {
    private int count = 0;

    public synchronized void inc(){
        this.count++;
    }

    public synchronized int incAndGet(){
        inc();
        return this.count;
    }
    /**
     *  when incAndGet() is called it calls inc() method
     *  both are synchronized but since they are synchronized on
     *  same monitor object i.e. the instance of Reentrance class
     *  and same thread that calls the both method
     *  so this is allowed
     */
}
