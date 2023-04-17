package Threads;

import Train.*;
import Data.*;
import Train.WagonsTypes.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileThread extends Thread{
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignored) {}
            try {
                writeTrainInformation();
            } catch (IOException ignored) {
            }
        }
    }

    private void writeTrainInformation() throws IOException {
        List<Train> trains = Data.trains;
        trains.sort(Comparator.comparing(Train::getPercentageOfPath).reversed());

        StringBuilder sb = new StringBuilder();

        for (Train train : trains) {
            ArrayList<Wagon> wagons = train.getWagons();
            wagons.sort(Comparator.comparing(Wagon::getWeight));

            sb.append("Train " + train.getLocomotive().getId() + " (distance: ")
                    .append(Math.round(train.getPercentageOfPath()))
                    .append("%):\n")
                    .append("Locomotive: ")
                    .append(train.getLocomotive().getName())
                    .append("\n")
                    .append("Current station: ")
                    .append(train.getCurrentStation().getName())
                    .append("\n")
                    .append("Starting station - destination station: ")
                    .append(train.locomotive.getSourceStation().getName())
                    .append(" - ")
                    .append(train.locomotive.getDestinationStation().getName())
                    .append("\n")
                    .append("Wagons: \n");

            for (Wagon wagon : wagons) {
                sb.append(wagon.toString())
                        .append("\n");
            }

            sb.append("\n");
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("AppState.txt"), StandardOpenOption.APPEND)) {
            writer.write(sb.toString());
        }
    }

}
