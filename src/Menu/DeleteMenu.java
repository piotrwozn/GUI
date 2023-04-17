package Menu;

import Data.Check;
import Data.Data;
import Data.Help;
import Train.Station;
import Train.Locomotive;
import Train.Train;
import Train.WagonsTypes.Wagon;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteMenu {
    public static void delete() {
        boolean gate = true;
        while (gate) {
            System.out.println("1 -> Delete locomotive");
            System.out.println("2 -> Delete wagon");
            System.out.println("3 -> Delete train by disconnecting everything");
            System.out.println("4 -> Delete station");
            System.out.println("5 -> Disconnect station");
            System.out.println("0 -> Exit");
            String choose = new Scanner(System.in).next();
            int ans = Check.check(choose, 5);
            switch (ans) {
                case (0) -> gate = false;
                case (1) -> deleteLocomotive();
                case (2) -> deleteWagon();
                case (3) -> deleteTrain();
                case (4) -> deleteStation();
                case (5) -> disconnectStation();
            }
        }
    }

    private static void disconnectStation() {
        ArrayList<Station> stations = Data.stations;
        if (stations.size() > 0) {
            Help.disconnectStation();
        } else {
            System.out.println("There are no stations to disconnect");
        }
    }

    private static void deleteStation() {
        ArrayList<Station> stations = Data.stations;
        if (stations.size() > 0) {
            Help.deleteStation();
        } else {
            System.out.println("There are no stations to delete");
        }
    }

    private static void deleteTrain() {
        ArrayList<Train> trains = Data.getAvailableTrains();
        if (trains.size() > 0) {
            Help.deleteTrain();
        } else {
            System.out.println("There are no trains to remove");
        }
    }

    private static void deleteWagon() {
        ArrayList<Wagon> wagons = Data.getAvailableWagons();
        if (wagons.size() > 0) {
            Help.deleteWagon();
        } else {
            System.out.println("There are no wagons to remove");
        }
    }

    private static void deleteLocomotive() {
        ArrayList<Locomotive> locomotives = Data.getAvailableLocomotives();
        if (locomotives.size() > 0) {
            Help.deleteLocomotive();
        } else {
            System.out.println("There are no locomotives to remove");
        }
    }
}
