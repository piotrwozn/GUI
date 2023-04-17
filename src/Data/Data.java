package Data;

import Train.Station;
import Train.Locomotive;
import Train.Train;
import Train.WagonsTypes.Wagon;

import java.util.ArrayList;

/**
 * Klasa przechowująca stałe wykorzystujące w projekcie
 */
public class Data {
    public static ArrayList<Train> trains = new ArrayList<>();
    public static ArrayList<Locomotive> locomotives = new ArrayList<>();
    public static ArrayList<Wagon> wagons = new ArrayList<>();
    public static ArrayList<Station> stations = new ArrayList<>();
    public static ArrayList<Thread> threads = new ArrayList<>();


    public Data() {
    }

    public static boolean isInTrain(Locomotive locomotive) {
        boolean ans = false;

        for (Train train : trains) {
            if (locomotive.getId() == train.getLocomotive().getId()) {
                ans = true;
                break;
            }
        }

        return ans;
    }

    public static boolean isInTrain(Wagon wagon) {
        boolean ans = false;

        for (Train train : trains) {
            ArrayList<Wagon> wagons = train.getWagons();
            for (Wagon value : wagons) {
                if (wagon.getId() == value.getId()) {
                    ans = true;
                    break;
                }
            }
        }

        return ans;
    }

    public static ArrayList<Locomotive> getAvailableLocomotives() {
        ArrayList<Locomotive> availableLocomotives = new ArrayList<>();

        for (Locomotive locomotive : locomotives) {
            if (!isInTrain(locomotive)) {
                availableLocomotives.add(locomotive);
            }
        }

        return availableLocomotives;
    }

    public static ArrayList<Wagon> getAvailableWagons() {
        ArrayList<Wagon> availableWagons = new ArrayList<>();

        for (Wagon wagon : wagons) {
            if (!isInTrain(wagon)) {
                availableWagons.add(wagon);
            }
        }

        return availableWagons;
    }

    public static ArrayList<Train> getAvailableTrains() {
        ArrayList<Train> availableTrains = new ArrayList<>();

        for (Train train : trains) {
            if (!train.isRunning()) {
                availableTrains.add(train);
            }
        }

        return availableTrains;
    }

    public static ArrayList<Train> getRunningTrains() {
        ArrayList<Train> runningTrains = new ArrayList<>();

        for (Train train : trains) {
            if (train.isRunning()) {
                runningTrains.add(train);
            }
        }

        return runningTrains;
    }

    public static ArrayList<Train> getNoMaxedTrains() {
        ArrayList<Train> availableTrains = getAvailableTrains();
        ArrayList<Train> trains1 = new ArrayList<>();

        for (Train availableTrain : availableTrains) {
            if (!availableTrain.maxWagonsConnected()) {
                trains1.add(availableTrain);
            }
        }
        return trains1;
    }
}
