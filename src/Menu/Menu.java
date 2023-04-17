package Menu;

import Data.Check;
import Data.Data;
import Data.Help;
import Threads.FileThread;
import Train.Station;
import Train.Locomotive;
import Train.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void menu() {
        FileThread fileThread = new FileThread();
        fileThread.start();
        while (true) {
            System.out.println("1 -> Create locomotive");
            System.out.println("2 -> Create wagon");
            System.out.println("3 -> Create station");
            System.out.println("4 -> Connect station");
            System.out.println("5 -> Load wagon");
            System.out.println("6 -> Create/Status/Start train");
            System.out.println("7 -> Delete train/locomotive/wagon/station");
            System.out.println("0 -> Exit");

            String choose = new Scanner(System.in).next();
            int ans = Check.check(choose, 7);
            switch (ans) {
                case (1) -> createLocomotive();
                case (2) -> createWagon();
                case (3) -> createStation();
                case (4) -> connectStation();
                case (5) -> loadWagon();
                case (6) -> TrainMenu.train();
                case (7) -> DeleteMenu.delete();
                case (0) -> System.exit(0);
            }
        }
    }

    private static void loadWagon() {
        ArrayList<Train> trains = Data.getAvailableTrains();
        if (Data.wagons.size() > 0) {
            if (trains.size() > 0) {
                Help.loadWagon();
            } else {
                System.out.println("Not available trains");
            }
        } else {
            System.out.println("Not available wagons");
        }
    }

    private static void connectStation() {
        if (Data.stations.size() > 1) {
            Help.connectStation();
        } else {
            System.out.println("Not enough stations!");
        }
    }

    private static void createStation() {

        String name = Check.getStringInput(new Scanner(System.in), "Enter name:");
        String city = Check.getStringInput(new Scanner(System.in), "Enter city:");

        Data.stations.add(new Station(name, city));

        System.out.println("Created " + Data.stations.get(Data.stations.size() - 1));
    }

    public static void createWagon() {

        String sender = Check.getStringInput(new Scanner(System.in), "Enter sender:");
        String security = Check.getStringInput(new Scanner(System.in), "Enter security:");
        double netWeight = Check.getDoubleInput(new Scanner(System.in), "Enter net weight:");
        double grossWeight = Check.getDoubleInput(new Scanner(System.in), "Enter gross weight:");
        int numSeats = Check.getIntInput(new Scanner(System.in), "Enter number of seats:");
        boolean needElec = Check.getBooleanInput(new Scanner(System.in), "Enter need electricity:");

        ChooseWagon.chooseWagonType(sender, security, netWeight, grossWeight, numSeats, needElec);
    }


    private static void createLocomotive() {

        if (Data.stations.size() > 1) {
            int maxWagons = Check.getIntInput(new Scanner(System.in), "Enter maximum number of wagons:");
            int maxLoad = Check.getIntInput(new Scanner(System.in), "Enter maximum load:");
            int maxWagonElec = Check.getIntInput(new Scanner(System.in), "Enter maximum number of electric wagons:");
            String name = Check.getStringInput(new Scanner(System.in), "Enter name:");
            Station homeStation = Data.stations.get(Check.chooseStation("Choose home station:"));
            Station sourceStation = Data.stations.get(Check.chooseStation("Choose source station:"));
            Station destinationStation = Data.stations.get(Check.chooseStation("Choose destination station:"));
            double speed = Check.getDoubleInput(new Scanner(System.in), "Enter speed:");

            Data.locomotives.add(new Locomotive(maxWagons, maxLoad, maxWagonElec, name, homeStation, sourceStation, destinationStation, speed));
            System.out.println("Created " + Data.locomotives.get(Data.locomotives.size() - 1));
        } else {
            System.out.println("No stations available!");
        }
    }

}