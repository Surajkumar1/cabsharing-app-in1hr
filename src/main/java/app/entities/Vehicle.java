package app.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {

    String vehicleId;
    String name;
    String vehicleRegNo;
    String userId;
    String mfgDate;

}
