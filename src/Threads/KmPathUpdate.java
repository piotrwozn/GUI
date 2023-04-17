package Threads;

import Train.*;

public class KmPathUpdate extends Thread{
    Train train;
    private double kmPath;
    private double kmInPath;

    public KmPathUpdate(Train train) {
        this.train = train;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!train.onStation) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {
                }
                kmInPath += train.speed * 1 / 60000;
                train.percentageOfPath = Math.min(kmInPath / kmPath * 100, 100);
                if (train.percentageOfPath >= 100) {
                    break;
                }
            }
        }
    }

    public void setKmPath(double kmPath) {
        this.kmPath = kmPath;
    }

    public void setKmInPath(double kmInPath) {
        this.kmInPath = kmInPath;
    }
}
