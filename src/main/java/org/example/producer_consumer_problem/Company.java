package org.example.producer_consumer_problem;

public class Company {
    private int n;
    private boolean b=false;
    synchronized public void produce_item(int n)
    {
        if(b)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        System.out.println("Produced item - "+this.n);
        b = true;
        notify();
    }
    synchronized public int consume_item()
    {
        if(!b)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed item - "+this.n);
        b = false;
        notify();
        return n;
    }
}
