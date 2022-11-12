package org.example.JavaThreadsBasics;

public class StoppableThread {
    public static class StoppableRunnable implements Runnable{
        private boolean stopRequested = false;

        public synchronized boolean isStopRequested() {
            return stopRequested;
        }

        public synchronized void setStopRequested(boolean stopRequested) {
            this.stopRequested = stopRequested;
        }

        private void sleep(long millis){
            try{
                Thread.sleep(millis);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            System.out.println("Stoppable Runnable running");
            while(!isStopRequested()){
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("Stoppable Runnable stopped");
        }
    }
    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable,"myThread");
        thread.start();
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Requesting stop");
        stoppableRunnable.setStopRequested(true);
        System.out.println("stop requested");
    }
}
