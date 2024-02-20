package lab1Threads;

import java.util.concurrent.atomic.AtomicBoolean;

class Abacus extends Thread {

    private static int threadCount = 0;
    private int threadNumber;
    private float step; 
    private double sum = 0;
    private long steps = 0;
    private AtomicBoolean running = new AtomicBoolean(true);

    public Abacus(float step) {
        this.threadNumber = threadCount++;
        this.step = step;
    }
    
    public void stopThread() {
        running.set(false);
        interrupt();
    }

    public void getSum() {
    	System.out.println("Thread " + threadNumber 
    			                     + ": Sum = " + String.format("%.5f", sum) 
    							     + " Steps = " + steps);
    }

    @Override
    public void run() {
    	while (running.get() && !Thread.currentThread().isInterrupted()) {
            sum += step;
            steps += 1;
        }
        
    }
}
