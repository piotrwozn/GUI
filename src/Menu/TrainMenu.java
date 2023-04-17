package Menu;

import Data.Check;
import Data.Data;
import Data.Help;
import Train.Locomotive;
import Train.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class TrainMenu {

    public static void train() {
        boolean gate = true;

        while (gate) {
            System.out.println("1 -> Create train");
            System.out.println("2 -> Start train");
            System.out.println("3 -> Connect wagon");
            System.out.println("4 -> Disconnect wagon");
            System.out.println("5 -> Train status");
            System.out.println("0 -> Back");

            String choose = new Scanner(System.in).next();
            int ans = Check.check(choose, 5);

            switch (ans) {
                case (1) -> createTrain();
                case (2) -> startTrain();
                case (3) -> connectWagon();
                case (4) -> disconnectWagon();
                case (5) -> trainStatus();
                case (0) -> gate = false;
            }
        }
    }

    private static void connectWagon() {
        ArrayList<Train> trains = Data.getNoMaxedTrains();
        if (trains.size() > 0) {
            Help.connectWagon();
        } else {
            System.out.println("There are no trains available");
        }
    }

    private static void disconnectWagon() {
        ArrayList<Train> trains = Data.getAvailableTrains();
        if (trains.size() > 0) {
            Help.disconnectWagon();
        } else {
            System.out.println("There are no trains available");
        }
    }

    private static void trainStatus() {
        ArrayList<Train> trains = Data.getRunningTrains();
        if (trains.size() > 0) {
            Help.trainStatus();
        } else {
            System.out.println("There are no running trains");
        }
    }

    private static void startTrain() {
        ArrayList<Train> trains = Data.getAvailableTrains();

        if (trains.size() > 0) {
            Help.startTrain();
        } else {
            System.out.println("There are no trains available");
        }
    }

    private static void createTrain() {
        ArrayList<Locomotive> locomotives = Data.getAvailableLocomotives();
        if (locomotives.size() > 0) {
            Help.createTrain();
        } else {
            System.out.println("There are no locomotives available");
        }
    }
}
