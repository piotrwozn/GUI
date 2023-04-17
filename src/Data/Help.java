package Data;

import Train.Station;
import Threads.TrainThread;
import Train.Locomotive;
import Train.Train;
import Train.WagonsTypes.Wagon;

import java.util.ArrayList;
import java.util.Scanner;

public class Help {

    public static void loadWagon() {
        ArrayList<Train> trains = Data.getAvailableTrains();
        System.out.println("Available wagons :");
        for (Train train : trains) {
            System.out.println(train);
            ArrayList<Wagon> wagons = train.getWagons();
            for (int j = 0; j < wagons.size(); j++) {
                System.out.println(j + " -> " + wagons.get(j));
            }
            System.out.println("Another train ?");
            System.out.println("0 -> yes");
            System.out.println("1 -> no");
            String choose = new Scanner(System.in).next();
            int ans = Check.check(choose, 1);
            if (ans == 1) {
                while (true) {
                    int answer = Check.getIntInput(new Scanner(System.in), "Which wagon do you want to load ?");
                    if (answer < train.getWagons().size() && answer >= 0) {
                        train.getWagons().get(answer).setLoaded(true);
                        if (train.isOverloaded()) {
                            train.getWagons().get(answer).setLoaded(false);
                            System.out.println("Weight exceeds max load of locomotive");
                        } else {
                            System.out.println("Wagon is loaded");
                        }
                        break;
                    } else {
                        System.out.println("There is no " + answer + " wagon");
                    }
                }
                break;
            }
        }
    }

    public static void connectWagon() {
        ArrayList<Train> trains = Data.getNoMaxedTrains();
        ArrayList<Wagon> wagons = Data.getAvailableWagons();

        if (trains.size() > 0) {
            while (true) {
                System.out.println("Available trains:");
                for (int i = 0; i < trains.size(); i++) {
                    System.out.println(i + " -> " + trains.get(i));
                }
                int ans = Check.getIntInput(new Scanner(System.in), "Choose train:");
                if (ans >= 0 && ans < trains.size() - 1) {
                    connect(trains, wagons, ans);
                    break;
                } else {
                    System.out.println("You provided the wrong train");
                }
            }
        } else {
            System.out.println("No available trains");
        }
    }

    private static void connect(ArrayList<Train> trains, ArrayList<Wagon> wagons, int ans) {
        while (true) {
            System.out.println("Available wagons:");
            for (int i = 0; i < wagons.size(); i++) {
                System.out.println(i + " -> " + wagons.get(i));
            }
            int answer = Check.getIntInput(new Scanner(System.in), "Choose wagons:");
            if (answer >= 0 && answer <= wagons.size()) {
                if (wagons.get(answer).isNeedElec()) {
                    if (trains.get(ans).maxElecConnected()) {
                        System.out.println("You can't connect this wagon because it would exceed the max of electric wagons");
                    } else {
                        trainOverload(trains, wagons, ans, answer);
                    }
                } else {
                    trainOverload(trains, wagons, ans, answer);
                }
                break;
            } else {
                System.out.println("You picked the wrong wagon");
            }
        }
    }

    public static void disconnectWagon() {
        ArrayList<Train> trains = Data.getAvailableTrains();

        while (true) {
            System.out.println("Available trains: ");
            for (int i = 0; i < trains.size(); i++) {
                System.out.println(i + " -> " + trains.get(i));
            }
            int ans = Check.getIntInput(new Scanner(System.in), "Choose train: ");

            if (ans >= 0 && ans < trains.size()) {
                if (trains.get(ans).getWagons().size() == 0) {
                    System.out.println("This train doesn't have any wagon");
                } else {
                    while (true) {
                        System.out.println("Wagons connected to this train:");
                        for (int i = 0; i < trains.get(ans).getWagons().size(); i++) {
                            System.out.println(i + " -> " + trains.get(ans).getWagons().get(i));
                        }
                        int answer = Check.getIntInput(new Scanner(System.in), "Choose wagon: ");

                        if (answer >= 0 && answer < trains.get(ans).getWagons().size()) {
                            trains.get(ans).getWagons().remove(trains.get(ans).getWagons().get(answer));
                            System.out.println("Wagon got disconnected");
                            break;
                        } else {
                            System.out.println("You picked wrong wagon");
                        }
                    }
                }
                break;
            } else {
                System.out.println("You picked a wrong train");
            }
        }
    }

    public static void startTrain() {
        ArrayList<Train> trains = Data.getAvailableTrains();

        while (true) {
            System.out.println("Available trains: ");
            for (int i = 0; i < trains.size(); i++) {
                System.out.println(i + " -> " + trains.get(i));
            }
            int ans = Check.getIntInput(new Scanner(System.in), "Choose train: ");

            if (ans >= 0 && ans <= trains.size()) {
                TrainThread trainThread = new TrainThread(trains.get(ans));
                Data.threads.add(trainThread);
                Data.threads.get(Data.threads.size()-1).start();
                System.out.println("Train " + trains.get(ans).locomotive.getName() + " starting at station " + trains.get(ans).currentStation.name);
                break;
            } else {
                System.out.println("You picked wrong train");
            }
        }
    }

    public static void connectStation() {
        while (true) {
            String station = Data.stations.get(Check.chooseStation("Enter first station:")).getName();
            String station1 = Data.stations.get(Check.chooseStation("Enter secound station:")).getName();
            if (station.equals(station1)) {
                System.out.println("You can't connect the same stations");
            } else {
                while (true) {
                    double km = Check.getDoubleInput(new Scanner(System.in), "Enter the distance between stations (km): ");
                    if (km > 0) {
                        int j = -1;
                        int d = -1;
                        for (int i = 0; i < Data.stations.size(); i++) {
                            if(Data.stations.get(i).getName().equals(station)) {
                                j = i;
                            }
                            if(Data.stations.get(i).getName().equals(station1)) {
                                d = i;
                            }
                        }
                        if(j == -1) {
                            System.out.println("You provided wrong station");
                        } else if(d == -1) {
                            System.out.println("You provided wrong station");
                        } else {
                            Data.stations.get(j).addConnection(Data.stations.get(d),km);
                            Data.stations.get(d).addConnection(Data.stations.get(j),km);
                        }
                        break;
                    } else {
                        System.out.println("Distance can't be smaller or equal 0km");
                    }
                }
                break;
            }
        }
    }

    public static void createTrain() {
        ArrayList<Locomotive> locomotives = Data.getAvailableLocomotives();
        ArrayList<Wagon> wagons = Data.getAvailableWagons();

        while (true) {
            System.out.println("Available locomotives: ");
            for (int i = 0; i < locomotives.size(); i++) {
                System.out.println(i + " -> " + locomotives.get(i));
            }
            int ans = Check.getIntInput(new Scanner(System.in), "Choose locomotive: ");

            if (ans >= 0 && ans < locomotives.size()) {
                System.out.println("How many wagons do you want to add?");
                int answer = Check.getIntInput(new Scanner(System.in), "Enter number of wagons you want to connect:");
                if (answer >= 0 && answer <= locomotives.get(ans).getMaxWagons()) {
                    Data.trains.add(new Train(locomotives.get(ans)));
                    for (int i = 0; i < answer; i++) {
                        connect(Data.trains, wagons, Data.trains.size() - 1);
                        System.out.println("Created " + Data.trains.get(Data.trains.size()-1));
                    }
                } else {
                    System.out.println("It exceeds max load of a locomotive");
                }
                break;
            } else {
                System.out.println("You picked wrong locomotive");
            }
        }
    }

    public static void deleteLocomotive() {
        ArrayList<Locomotive> locomotives = Data.getAvailableLocomotives();

        while (true) {
            System.out.println("Available locomotives: ");
            for (int i = 0; i < locomotives.size(); i++) {
                System.out.println(i + " -> " + locomotives.get(i));
            }
            int ans = Check.getIntInput(new Scanner(System.in), "Choose locomotive:");
            if (ans >= 0 && ans < locomotives.size()) {
                System.out.println("Deleted: " + locomotives.get(ans));
                Data.locomotives.remove(locomotives.get(ans));
                break;
            }
        }
    }

    public static void deleteWagon() {
        ArrayList<Wagon> wagons = Data.getAvailableWagons();

        while (true) {
            System.out.println("Available wagons: ");
            for (int i = 0; i < wagons.size(); i++) {
                System.out.println(i + " -> " + wagons.get(i));
            }
            int ans = Check.getIntInput(new Scanner(System.in), "Choose wagon:");
            if (ans >= 0 && ans < wagons.size()) {
                System.out.println("Deleted: " + wagons.get(ans));
                Data.wagons.remove(wagons.get(ans));
                break;
            }
        }
    }

    public static void deleteTrain() {
        ArrayList<Train> trains = Data.getAvailableTrains();

        while (true) {
            System.out.println("Available trains: ");
            for (int i = 0; i < trains.size(); i++) {
                System.out.println(i + " -> " + trains.get(i));
            }
            int ans = Check.getIntInput(new Scanner(System.in), "Choose train:");
            if (ans >= 0 && ans < trains.size()) {
                System.out.println("Deleted: " + trains.get(ans));
                Data.trains.remove(trains.get(ans));
                break;
            }
        }
    }

    public static void disconnectStation() {
        while (true) {
            System.out.println("Stations: ");
            for (int i = 0; i < Data.stations.size(); i++) {
                System.out.println(i + " -> " + Data.stations.get(i));
            }
            int station = Check.getIntInput(new Scanner(System.in), "Select station from which you want to disconnect:");
            if (station >= 0 && station < Data.stations.size()) {
                ArrayList<Station> connectedStations = Data.stations.get(station).getConnectedStations();
                while (true) {
                    System.out.println("Connected stations: ");
                    for (int i = 0; i < connectedStations.size(); i++) {
                        System.out.println(i + " -> " + connectedStations.get(i));
                    }
                    int connected = Check.getIntInput(new Scanner(System.in), "Select station which you want to disconnect: ");
                    if (connected >= 0 && connected < connectedStations.size()) {
                        Data.stations.get(station).disconnectStations(Data.stations.get(station), connectedStations.get(connected));
                        break;
                    } else {
                        System.out.println("You picked wrong station");
                    }
                }
                break;
            } else {
                System.out.println("You picked wrong station");
            }
        }
    }

    public static void deleteStation() {
        while (true) {
            System.out.println("Stations: ");
            for (int i = 0; i < Data.stations.size(); i++) {
                System.out.println(i + " -> " + Data.stations.get(i));
            }
            int station = Check.getIntInput(new Scanner(System.in), "Select station from which you want to disconnect:");
            if (station >= 0 && station < Data.stations.size()) {
                Data.stations.get(station).deleteStation();
                Data.stations.remove(station);
                break;
            } else {
                System.out.println("You picked wrong station");
            }
        }
    }

    public static void trainStatus() {
        while (true) {
            System.out.println("Choose train: ");
            for (int i = 0; i < Data.trains.size(); i++) {
                System.out.println(i + " -> " + Data.trains.get(i));
            }
            int train = Check.getIntInput(new Scanner(System.in), "Choose train inex");
            if (train >= 0 && train < Data.trains.size()) {
                System.out.println(Data.trains.get(train));
                System.out.println("Percentage of path: ");
                System.out.println(Math.round(Data.trains.get(train).percentageOfPath)+ "%");
                System.out.println("Percentage between stations: ");
                System.out.println(Math.round(Data.trains.get(train).percentageBetweenStations) + "%");
                System.out.println("Wagons: ");
                for (int i = 0; i < Data.trains.get(train).getWagons().size(); i++) {
                    System.out.println(Data.trains.get(train).getWagons().get(i));
                }
                break;
            } else {
                System.out.println("You provided wront train");
            }
        }
    }

    private static void trainOverload(ArrayList<Train> trains, ArrayList<Wagon> wagons, int ans, int answer) {
        trains.get(ans).getWagons().add(wagons.get(answer));
        if (trains.get(ans).isOverloaded()) {
            System.out.println("You can't connect wagon because it would exceed the max locomotive load");
            trains.get(ans).getWagons().remove(wagons.get(answer));
        } else {
            System.out.println("Wagon connected");
        }
    }

}
