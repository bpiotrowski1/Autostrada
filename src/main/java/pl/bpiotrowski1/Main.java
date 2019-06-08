package pl.bpiotrowski1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws VehicleNotFoundException {
        Scanner in = new Scanner(System.in);
        String line;
        Highway highway = new Highway();

        while (!(line = in.nextLine()).equalsIgnoreCase("zamknij")) {
            String[] command = line.split(" ");
            switch (command[0]) {
                case "wjazd":
                    if (command.length >= 3) {
                        try {
                            CarType carType = CarType.valueOf(command[2].toUpperCase());
                            highway.vehicleEntry(command[1], carType);

                        } catch (IllegalArgumentException iae) {
                            System.err.println("Błąd, zły typ pojazdu");
                        }
                    }
                    break;
                case "wyjazd":
                    if(command.length >= 2) {
                        System.out.println(highway.exitVehicle(command[1]));
                    }
                    break;
                case "sprawdz":
                    if(command.length >= 2) {
                        System.out.println(highway.searchVehicle(command[1]));
                    }
                    break;
            }
        }
    }
}
