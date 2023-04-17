package Train;

import java.util.Random;

public class Locomotive {

    private final int maxWagons;
    private final int maxLoad;
    private final int maxWagonsElec;
    private final String name;
    private final Station homeStation;
    private final Station sourceStation;
    private final Station destinationStation;
    private long id;
    private double speed;

    public Locomotive(int maxWagons, int maxLoad, int maxWagonsElec, String name, Station homeStation, Station sourceStation, Station destinationStation, double speed) {
        this.maxWagons = maxWagons;
        this.maxLoad = maxLoad;
        this.maxWagonsElec = maxWagonsElec;
        this.name = name;
        this.homeStation = homeStation;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.id = generateID(id);
        this.speed = speed;
    }

    private long generateID(long id) {
        long uniqueID = System.currentTimeMillis() + new Random().nextInt(9999);
        id = uniqueID;

        return id;
    }

    public int getMaxWagons() {
        return maxWagons;
    }

    public long getId() {
        return id;
    }

    public Station getSourceStation() {
        return sourceStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public int getMaxWagonsElec() {
        return maxWagonsElec;
    }

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Locomotive:" + "\n" +
                "maxWagons= " + maxWagons + "\n" +
                "maxLoad= " + maxLoad + "\n" +
                "maxWagonsElec= " + maxWagonsElec + "\n" +
                "name= " + name + '\n' +
                "homeStation= " + homeStation + '\n' +
                "sourceStation= " + sourceStation + '\n' +
                "destinationStation= " + destinationStation + '\n' +
                "id= " + id + "\n" +
                "speed= " + speed;
    }
}
