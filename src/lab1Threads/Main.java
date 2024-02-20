package lab1Threads;

import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Num of threads: ");
        int numThreads = scnr.nextInt();
 
        Abacus[] threads = new Abacus[numThreads];
        Timer[] timers = new Timer[numThreads];
        
        long[] executionTimes = new long[numThreads];
        
        for (int i = 0; i < numThreads; i++) {
            System.out.print("Thread " + i + ": " + " step: ");
            threads[i] = new Abacus(scnr.nextFloat());
            System.out.print("Thread " + i + ": " + " executionTime: ");
            executionTimes[i] = scnr.nextLong();
            timers[i] = new Timer();
        }
        scnr.close();

        for (Thread thread : threads)
            thread.start();
        
        Thread halt = new Thread(() -> {
            System.out.println("Calculating...");
  
            for(int i =0; i < numThreads; i++) {
            	timers[i].schedule(new MyTask(threads[i]), executionTimes[i] * 1000);
            }
            
        });
        halt.start();
        
        try {
            halt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        for (Thread thread : threads)
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
