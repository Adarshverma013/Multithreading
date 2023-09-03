package org.example.producer_consumer_problem;

public class Producer extends Thread{
    Company c;

    public Producer(Company c) {
        this.c = c;
    }

    @Override
    public void run() {
        int i = 1;
        while (true)
        {
            c.produce_item(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
