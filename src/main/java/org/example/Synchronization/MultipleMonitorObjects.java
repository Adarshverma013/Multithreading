package org.example.Synchronization;

public class MultipleMonitorObjects {
    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    private int counter1 = 0;
    private int counter2 = 0;

    /**
     * We can also use shared monitor objects shared via constructor
     */
    public MultipleMonitorObjects(Object monitor1, Object monitor2) {
        if(monitor1 == null || monitor2 == null)
            throw new IllegalArgumentException(
                    "Monitor object cannot be null"
            );
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
    }

    public void incCounter1(){
        synchronized (this.monitor1){
            counter1++;
        }
    }
    public void incCounter2(){
        synchronized (this.monitor2){
            counter2++;
        }
    }
}
