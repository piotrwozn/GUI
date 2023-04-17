package Data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Check {

    public static int check(String choose, int number) {
        char[] chars = choose.toCharArray();
        int ans = -2;

        if (chars.length > 1) {
            System.out.println("You didn't provide proper value");
            System.out.println("Try again");
            ans = -1;
        } else {
            for (int i = 48; i < 49 + number; i++) {
                if (chars[0] == i) {
                    ans = chars[0] - 48;
                    break;
                }
            }
            if (ans == -2) {
                System.out.println("You didn't provide proper value");
                System.out.println("Try again");
                ans = -1;
            }
        }

        return ans;
    }

    public static int chooseStation(String stationName) {
        boolean gate = true;
        int stationIndex = 0;
        while (gate) {
            System.out.println("Available stations :");
            for (int i = 0; i < Data.stations.size(); i++) {
                System.out.println(i + " -> " + Data.stations.get(i).toString());
            }
            stationIndex = Check.getIntInput(new Scanner(System.in), stationName);
            if (stationIndex > Data.stations.size() - 1) {
                System.out.println("Wrong station");
            } else {
                gate = false;
            }
        }
        return stationIndex;
    }


    public static boolean getBooleanInput(Scanner scanner, String prompt) {
        boolean input;
        while (true) {
            System.out.println(prompt);
            try {
                input = scanner.nextBoolean();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
        return input;
    }

    public static int getIntInput(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.println(prompt);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        double input;
        while (true) {
            System.out.println(prompt);
            try {
                input = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a valid decimal number.");
            }
        }
        return input;
    }

    public static String getStringInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

}
