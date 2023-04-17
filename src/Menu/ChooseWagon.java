package Menu;

import Data.Check;
import Data.Data;
import Train.WagonsTypes.*;

import java.util.Scanner;

public class ChooseWagon {

    public static void chooseWagonType(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec) {
        boolean gate = true;
        while (gate) {
            System.out.println("What type of wagon do you want to add ?");
            if (needElec) {
                System.out.println("1 -> passenger wagon");
                System.out.println("2 -> post wagon");
                System.out.println("3 -> restaurant wagon");
                System.out.println("4 -> cooling wagon");
                System.out.println("0 -> exit");
                String choose = new Scanner(System.in).next();
                int ans = Check.check(choose, 4);
                switch (ans) {
                    case (0) -> gate = false;
                    case (1) -> createPassengerWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (2) -> createPostWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (3) -> createRestaurantWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (4) -> createCoolingWagon(sender, security, netWeight, grossWeight, numSeats);
                }
            } else {
                System.out.println("1 -> luggage-post wagon");
                System.out.println("2 -> basic freight wagon");
                System.out.println("3 -> heavy freight wagon");
                System.out.println("4 -> liquid wagon");
                System.out.println("5 -> gas wagon");
                System.out.println("6 -> explosive wagon");
                System.out.println("7 -> toxic wagon");
                System.out.println("8 -> liquid-toxic wagon");
                System.out.println("0 -> exit");
                String choose = new Scanner(System.in).next();
                int ans = Check.check(choose, 8);
                switch (ans) {
                    case (0) -> gate = false;
                    case (1) -> createLuggagePostWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (2) -> createBasicFreightWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (3) -> createHeavyFreightWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (4) -> createLiquidWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (5) -> createGasWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (6) -> createExplosiveWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (7) -> createToxicWagon(sender, security, netWeight, grossWeight, numSeats);
                    case (8) -> createLiquidToxicWagon(sender, sender, netWeight, grossWeight, numSeats);
                }
            }
            gate = false;
        }
    }

    private static void createLiquidToxicWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        String additionalDevices = Check.getStringInput(new Scanner(System.in), "Enter addidiotnal devices:");
        String adaptation = Check.getStringInput(new Scanner(System.in), "Enter adaptation:");
        boolean harmsEnvironment = Check.getBooleanInput(new Scanner(System.in), "Enter harms environment:");
        double concetration = Check.getDoubleInput(new Scanner(System.in), "Enter concentration:");
        String liquidType = Check.getStringInput(new Scanner(System.in), "Enter liquid type:");
        double maxCapacity = Check.getDoubleInput(new Scanner(System.in), "Enter maximum capacity:");
        int doorsCount = Check.getIntInput(new Scanner(System.in), "Enter number of doors:");
        int handleCount = Check.getIntInput(new Scanner(System.in), "Enter number of handles:");

        Data.wagons.add(new LiquidToxicWagon(sender, security, netWeight, grossWeight, numSeats, false, additionalDevices, adaptation, harmsEnvironment, concetration, liquidType, maxCapacity, doorsCount, handleCount));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));
    }

    private static void createToxicWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        String additionalDevices = Check.getStringInput(new Scanner(System.in), "Enter additional devices:");
        String addaptation = Check.getStringInput(new Scanner(System.in), "Enter adaptation:");
        boolean isRadioactive = Check.getBooleanInput(new Scanner(System.in), "Is radioactive:");
        boolean isHarmful = Check.getBooleanInput(new Scanner(System.in), "Is harmful:");

        Data.wagons.add(new ToxicWagon(sender, security, netWeight, grossWeight, numSeats, false, additionalDevices, addaptation, isRadioactive, isHarmful));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));
    }

    private static void createExplosiveWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        String additionalDevices = Check.getStringInput(new Scanner(System.in), "Enter additional devices:");
        String addaptation = Check.getStringInput(new Scanner(System.in), "Enter adaptation:");
        String explosivesType = Check.getStringInput(new Scanner(System.in), "Enter explosives type:");
        boolean isDangerous = Check.getBooleanInput(new Scanner(System.in), "Is dangerous:");

        Data.wagons.add(new ExplosiveWagon(sender, security, netWeight, grossWeight, numSeats, false, additionalDevices, addaptation, explosivesType, isDangerous));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));

    }

    private static void createGasWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        int doorsCount = Check.getIntInput(new Scanner(System.in), "Enter number of doors");
        int handleCount = Check.getIntInput(new Scanner(System.in), "Enter number of handles");
        String gasType = Check.getStringInput(new Scanner(System.in), "Enter the type of gas:");
        double maxVolume = Check.getDoubleInput(new Scanner(System.in), "Enter the max volume");

        Data.wagons.add(new GasWagon(sender, security, netWeight, grossWeight, numSeats, false, doorsCount, handleCount, gasType, maxVolume));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));
    }

    private static void createLiquidWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        int doorsCount = Check.getIntInput(new Scanner(System.in), "Enter number of doors");
        int handleCount = Check.getIntInput(new Scanner(System.in), "Enter number of handles");
        String liquidType = Check.getStringInput(new Scanner(System.in), "Enter the type of liquid:");
        double maxCapacity = Check.getDoubleInput(new Scanner(System.in), "Enter the max capacity");

        Data.wagons.add(new LiquidWagon(sender, security, netWeight, grossWeight, numSeats, false, doorsCount, handleCount, liquidType, maxCapacity));
        System.out.println(Data.wagons.get(Data.wagons.size() - 1));
    }

    private static void createHeavyFreightWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        String additionalDevices = Check.getStringInput(new Scanner(System.in), "Enter the additional device:");
        String adaptation = Check.getStringInput(new Scanner(System.in), "Enter to what type the wagon is adapted to:");

        Data.wagons.add(new HeavyFreightWagon(sender, security, netWeight, grossWeight, numSeats, false, additionalDevices, adaptation));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));
    }

    private static void createBasicFreightWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        int doorsCount = Check.getIntInput(new Scanner(System.in), "Enter number of doors");
        int handleCount = Check.getIntInput(new Scanner(System.in), "Enter numer of handles:");

        Data.wagons.add(new BasicFreightWagon(sender, security, netWeight, grossWeight, numSeats, false, doorsCount, handleCount));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));
    }

    private static void createLuggagePostWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        int maxLuggageCount = Check.getIntInput(new Scanner(System.in), "Enter maximum luggage count:");
        int luggageCompartmentsCount = Check.getIntInput(new Scanner(System.in), "Enter number of compartments:");

        Data.wagons.add(new LuggagePostWagon(sender, security, netWeight, grossWeight, numSeats, false, maxLuggageCount, luggageCompartmentsCount));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));
    }

    private static void createCoolingWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        int doorCount = Check.getIntInput(new Scanner(System.in), "Enter number of doors:");
        int handleCount = Check.getIntInput(new Scanner(System.in), "Enter number of handles:");
        int minTemperature = Check.getIntInput(new Scanner(System.in), "Enter minimum temperature:");
        int maxTemperature = Check.getIntInput(new Scanner(System.in), "Enter maximum temperature:");

        Data.wagons.add(new CoolingWagon(sender, security, netWeight, grossWeight, numSeats, true, doorCount, handleCount, minTemperature, maxTemperature));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));
    }

    private static void createRestaurantWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        int tableCount = Check.getIntInput(new Scanner(System.in), "Enter number of tables:");
        String foodType = Check.getStringInput(new Scanner(System.in), "Enter food type:");

        Data.wagons.add(new RestaurantWagon(sender, security, netWeight, grossWeight, numSeats, true, tableCount, foodType));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));

    }

    private static void createPostWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        int postBoxCount = Check.getIntInput(new Scanner(System.in), "Enter number of boxes:");
        int maxLetterCount = Check.getIntInput(new Scanner(System.in), "Enter max number of letters:");

        Data.wagons.add(new PostWagon(sender, security, netWeight, grossWeight, numSeats, true, postBoxCount, maxLetterCount));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));
    }

    private static void createPassengerWagon(String sender, String security, double netWeight, double grossWeight, int numSeats) {
        int compartment = Check.getIntInput(new Scanner(System.in), "Enter number of compartments:");
        int wagonClass = Check.getIntInput(new Scanner(System.in), "Enter wagon class:");

        Data.wagons.add(new PassengerWagon(sender, security, netWeight, grossWeight, numSeats, true, compartment, wagonClass));
        System.out.println("Created: " + Data.wagons.get(Data.wagons.size() - 1));
    }
}
