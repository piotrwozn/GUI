package Threads;

import Train.Train;
import Exception.*;

import java.util.Random;

public class SpeedUpdateThread extends Thread {
    Train train;

    public SpeedUpdateThread(Train train) {
        this.train = train;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            double speedChangeFactor = random.nextBoolean() ? 1.03 : 0.97;
            train.speed = train.speed * speedChangeFactor;
            if (train.speed > 200) {
                try {
                    throw new RailroadHazard(train + "\n" + train.locomotive.getName() + " exceeded the speed limit of 200.");
                } catch (RailroadHazard e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
