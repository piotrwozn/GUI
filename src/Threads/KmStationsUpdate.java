package Threads;

import Train.*;

public class KmStationsUpdate extends Thread{
    Train train;
    private double kmBetweenStations;
    private double distance;

    public KmStationsUpdate(Train train) {
        this.train = train;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            if(!train.onStation) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {
                }
                kmBetweenStations += train.speed * 1 / 60000;
                train.percentageBetweenStations = Math.min(kmBetweenStations / distance * 100, 100);
                if(train.percentageBetweenStations >= 100) {
                    break;
                }
            }
        }
    }

    public void setKmBetweenStations(double kmBetweenStations) {
        this.kmBetweenStations = kmBetweenStations;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
