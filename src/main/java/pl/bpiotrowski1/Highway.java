package pl.bpiotrowski1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Highway {
    private Map<String, VehicleInfo> vehicles = new HashMap<>();

    public void vehicleEntry(String registrationNumber, CarType carType) {
        vehicles.put(registrationNumber, new VehicleInfo(registrationNumber, carType, LocalDateTime.now()));
        System.out.println("Pojazd " + vehicles.get(registrationNumber) + " wjechal na autostrade.");
    }

    public VehicleInfo searchVehicle(String registrationNumber) throws VehicleNotFoundException {
        if(vehicles.containsKey(registrationNumber)) {
            System.out.println("Pojazd wciaz znajduje sie na autostradzie");
            return vehicles.get(registrationNumber);
        }
        throw new VehicleNotFoundException("Nie można znaleźć pojazdu");
    }

    public Double exitVehicle(String registrationNumber) throws VehicleNotFoundException {
        if(!vehicles.containsKey(registrationNumber)) {
            throw new VehicleNotFoundException("Nie można znaleźć pojazdu");
        }
        VehicleInfo vehicleInfo = vehicles.get(registrationNumber);
        Duration duration = Duration.between(vehicleInfo.getDateOfEntry(), LocalDateTime.now());

        double toPay = 0.0;
        switch (vehicleInfo.getCarType()) {
            case CAR:
                toPay = duration.getSeconds() * 0.3;
                break;
            case TRUCK:
                toPay = duration.getSeconds() * 0.5;
                break;
            case MOTORCYCLE:
                toPay = duration.getSeconds() * 0.2;
                break;
        }

        vehicles.remove(registrationNumber);
        System.out.println("Pojazd " + registrationNumber + " opuszcza autostrade, do zaplaty " + toPay + "zł");
        return toPay;
    }
}
