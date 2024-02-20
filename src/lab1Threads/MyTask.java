package lab1Threads;

import java.util.TimerTask;

class MyTask extends TimerTask {
    private Abacus abacus;

    public MyTask(Abacus abacus) {
        this.abacus = abacus;
    }

    @Override
    public void run() {
        if (abacus instanceof Abacus) {
        	abacus.stopThread();
        	abacus.getSum();
        }
    }
}
