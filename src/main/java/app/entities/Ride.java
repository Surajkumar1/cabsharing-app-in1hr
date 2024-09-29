package app.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ride {

    String rideId;
    String userId;
    String vehicleId;
    String source;
    String destination;
    Integer availableSeat;
    Integer bookedSeats;
    String status;
    Long startTime;
    Long endTime;

}
