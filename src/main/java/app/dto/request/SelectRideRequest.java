package app.dto.request;

import app.enums.RideStategy;
import app.enums.RideType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectRideRequest {

    String userId;
    String source;
    String destination;
    Long startTime;
    Long endTime;
    Integer numSeats;
    RideType  rideType;
    RideStategy rideStategy;

}
