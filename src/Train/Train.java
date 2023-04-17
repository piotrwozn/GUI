package Train;

import Train.WagonsTypes.Wagon;
import java.util.ArrayList;

public class Train {

    public final Locomotive locomotive;
    public final ArrayList<Wagon> wagons;
    public Station currentStation;
    public Station destination;
    public Station start;
    public boolean isRunning;
    public double speed;
    public double percentageOfPath;
    public double percentageBetweenStations;
    public boolean onStation;


    public Train(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.wagons = new ArrayList<>();
        this.destination = locomotive.getDestinationStation();
        this.currentStation = locomotive.getSourceStation();
        this.start = locomotive.getSourceStation();
        this.speed = locomotive.getSpeed();
        this.isRunning = false;
        this.onStation = false;
    }

    public boolean isOverloaded() {
        boolean ans = false;
        double sum = 0;

        for (int i = 0; i < wagons.size(); i++) {
            sum += wagons.get(i).getWeight();
            if (sum > locomotive.getMaxLoad()) {
                ans = true;
            }
        }
        return ans;
    }

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean maxElecConnected() {
        boolean ans = false;
        int sum = 0;
        for (Wagon wagon : wagons) {
            if (wagon.isNeedElec()) {
                sum++;
            }
        }

        if (sum == locomotive.getMaxWagonsElec()) {
            ans = true;
        }
        return ans;
    }

    public boolean maxWagonsConnected() {
        return locomotive.getMaxWagons() == wagons.size();
    }

    public double getPercentageOfPath() {
        return percentageOfPath;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    @Override
    public String toString() {
        return "Train:" + "\n" +
                "locomotive= " + locomotive.getId() + "\n" +
                "wagons= " + wagons + "\n" +
                "start= " + currentStation + "\n" +
                "destination= " + destination + "\n" +
                "isRunning= " + isRunning;
    }
}
