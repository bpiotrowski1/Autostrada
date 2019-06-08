package pl.bpiotrowski1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
class VehicleInfo {
    @Getter private String registrationNumber;
    @Getter private CarType carType;
    private LocalDateTime dateOfEntry;

    public VehicleInfo(String registrationNumber, CarType carType) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
    }
}
