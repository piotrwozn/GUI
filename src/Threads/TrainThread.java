package Threads;

import Data.Data;
import Train.*;
import Exception.*;

import java.util.List;

public class TrainThread extends Thread{
    private Train train;
    public int currentPathIndex;


    public TrainThread (Train train) {
        this.train = train;
    }

    @Override
    public void run() {
        if(!Thread.currentThread().isInterrupted()) {
            SpeedUpdateThread speedUpdateThread = new SpeedUpdateThread(train);
            speedUpdateThread.start();

            Station tmp = null;
            for (int i = 0; i < 2; i++) {
                train.isRunning = true;
                if (i == 1) {
                    tmp = train.destination;
                    train.destination = train.start;
                }
                List<Station> path = train.currentStation.findPath(train.destination);
                KmPathUpdate kmPathUpdate = new KmPathUpdate(train);
                kmPathUpdate.setKmInPath(0);
                kmPathUpdate.setKmPath(train.currentStation.getDistanceTo(train.destination));


                kmPathUpdate.start();
                currentPathIndex = 0;

                for (int j = currentPathIndex + 1; j < path.size(); j++) {
                    Station nextStation = path.get(j);
                    int indexOfNextStation = train.currentStation.connectedStations.indexOf(nextStation);
                    double distance = train.currentStation.km.get(indexOfNextStation);
                    KmStationsUpdate kmStationsUpdate = new KmStationsUpdate(train);
                    kmStationsUpdate.setKmBetweenStations(0);
                    kmStationsUpdate.setDistance(distance);

                    kmStationsUpdate.start();
                    try {
                        kmStationsUpdate.join();
                    } catch (InterruptedException ignored) {}

                    kmStationsUpdate.interrupt();
                    train.onStation = true;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {}
                    train.onStation = false;

                    train.currentStation = nextStation;
                    currentPathIndex = j;
                }

                try {
                    kmPathUpdate.join();
                    train.onStation = true;
                } catch (InterruptedException ignored) {}

                if(i == 0) {
                    train.isRunning = false;
                }
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException ignored) {}
                train.onStation = false;
            }
            train.isRunning = false;
            train.destination = tmp;
            speedUpdateThread.interrupt();
            Thread.currentThread().interrupt();
        }
    }
}
