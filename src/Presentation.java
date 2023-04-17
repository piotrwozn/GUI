import Data.*;
import Threads.FileThread;
import Threads.TrainThread;
import Train.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Presentation {
    public static void main(String[] args) {
        FileThread fileThread = new FileThread();
        fileThread.start();
        List<Station> stations = new ArrayList<>();
        int numberOfStations = 100;

        for (int i = 0; i < numberOfStations; i++) {
            stations.add(new Station("Station" + i, "City"));
        }


        Random random = new Random();
        for (int i = 0; i < numberOfStations; i++) {
            Station currentStation = stations.get(i);
            Station nextStation = stations.get((i + 1) % numberOfStations);
            double distance = 10 + random.nextDouble() * 90;

            currentStation.addConnection(nextStation, distance);
            nextStation.addConnection(currentStation, distance);
        }


        for (int i = 0; i < 25; i++){
        int param1 = 1 + random.nextInt(10);
        int param2 = 1 + random.nextInt(10);
        int param3 = 1 + random.nextInt(10);
        String paramName = "Locomotive" + i;

        int stationIndex1 = random.nextInt(stations.size());
        int stationIndex2 = random.nextInt(stations.size());
        int stationIndex3 = random.nextInt(stations.size());

        Station randomStation1 = stations.get(stationIndex1);
        Station randomStation2 = stations.get(stationIndex2);
        Station randomStation3 = stations.get(stationIndex3);

        int param7 = 50 + random.nextInt(150);

        Locomotive locomotive = new Locomotive(param1, param2, param3, paramName, randomStation1, randomStation2, randomStation3, param7);
        Data.locomotives.add(locomotive);
        Train train = new Train(Data.locomotives.get(Data.locomotives.size() - 1));
        Data.trains.add(train);
            TrainThread trainThread = new TrainThread(Data.trains.get(Data.trains.size()-1));
            trainThread.start();
    }
}
/*
    public static void main(String[] args) {
        Station stationA = new Station("A", "City1");
        Station stationB = new Station("B", "City1");
        Station stationC = new Station("C", "City1");
        Station stationD = new Station("D", "City1");

        stationA.addConnection(stationB, 5);
        stationB.addConnection(stationC, 7);
        stationC.addConnection(stationD, 3);
        stationA.addConnection(stationD, 10);

        List<Station> path = stationA.findPath(stationC);

        if (path != null) {
            System.out.print("Path found: ");
            for (Station station : path) {
                System.out.print(station.name + " -> ");
            }
        } else {
            System.out.println("No path found");
        }
    }*/

}
