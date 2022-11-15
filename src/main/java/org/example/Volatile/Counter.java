package org.example.Volatile;

/**
 * Case with limitation of volatile keyword
 * Here synchronized block will be required
 * to work this properly when two threads are accessing at same time
 */
public class Counter {
    private volatile int count = 0;

    public boolean inc(){
        if(this.count == 1_000_000){
            return false;
        }
        count++;
        return true;
    }
    public int getCount(){
        return count;
    }
}
