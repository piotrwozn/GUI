package Train;

import java.util.*;

public class Station {
    public String name;
    public String city;
    public ArrayList<Station> connectedStations;
    public ArrayList<Double> km;

    public Station(String name, String city) {
        this.name = name;
        this.city = city;
        this.connectedStations = new ArrayList<>();
        this.km = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Station> getConnectedStations() {
        return connectedStations;
    }

    public void addConnection(Station station, double distance) {
        this.connectedStations.add(station);
        this.km.add(distance);
    }

    public List<Station> findPath(Station target) {
        Queue<List<Station>> queue = new LinkedList<>();
        Set<Station> visited = new HashSet<>();

        List<Station> initialPath = new ArrayList<>();
        initialPath.add(this);
        queue.add(initialPath);

        while (!queue.isEmpty()) {
            List<Station> currentPath = queue.poll();
            Station currentStation = currentPath.get(currentPath.size() - 1);

            if (currentStation.equals(target)) {
                return currentPath;
            }

            if (!visited.contains(currentStation)) {
                visited.add(currentStation);

                for (Station connectedStation : currentStation.connectedStations) {
                    List<Station> newPath = new ArrayList<>(currentPath);
                    newPath.add(connectedStation);
                    queue.add(newPath);
                }
            }
        }

        return null;
    }

    public void deleteStation() {
        while (!connectedStations.isEmpty()) {
            disconnectStations(this, connectedStations.get(0));
        }
    }

    public void disconnectStations(Station station1, Station station2) {
        int index1 = station1.connectedStations.indexOf(station2);
        int index2 = station2.connectedStations.indexOf(station1);

        if (index1 != -1 && index2 != -1) {
            station1.connectedStations.remove(index1);
            station1.km.remove(index1);

            station2.connectedStations.remove(index2);
            station2.km.remove(index2);
        } else {
            System.out.println("The stations " + station1.name + " and " + station2.name + " are not connected.");
        }
    }

    public double getDistanceTo(Station target) {
        List<Station> path = this.findPath(target);
        if (path == null) {
            return Double.POSITIVE_INFINITY;
        }

        double distance = 0.0;
        for (int i = 0; i < path.size() - 1; i++) {
            Station currentStation = path.get(i);
            Station nextStation = path.get(i + 1);
            int indexOfNextStation = currentStation.connectedStations.indexOf(nextStation);
            distance += currentStation.km.get(indexOfNextStation);
        }

        return distance;
    }



    @Override
    public String toString() {
        return "Station:" + "\n" +
                "name= " + name + '\n' +
                "city= " + city;
    }
}
