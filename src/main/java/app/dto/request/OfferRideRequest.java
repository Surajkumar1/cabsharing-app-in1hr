package app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferRideRequest {

    String userId;
    String vehicleId;
    String source;
    String destination;
    Integer availableSeat;
    Long startTime;
    Long endTime;

}
