package app.dto.request;

import app.enums.RideStategy;
import app.enums.RideType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchRideRequest {

    String userId;
    String source;
    String destination;
    Integer numSeats;
    Long startTime;
    Long endTime;
    RideType  rideType;

}
