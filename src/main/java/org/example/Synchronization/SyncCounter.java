package org.example.Synchronization;

public class SyncCounter {
    private long count = 0;

    /**
     * In this example the count will not reach
     * to 2_000_000 as the methods are not in sync
     */
//    public void incCount(){
//        this.count++;
//    }
//    public long getCount(){
//        return this.count;
//    }

    /**
     * Use of synchronized keyword will
     * make the code work as desired and
     * both thread will get a lock on the monitor
     * object when trying to access the methods
     */
    public synchronized void incCount(){
        this.count++;
    }
    public synchronized long getCount(){
        return this.count;
    }
}
