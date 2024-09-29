package app.dao;

import app.dto.request.OfferRideRequest;
import app.dto.request.SearchRideRequest;
import app.dto.request.SelectRideRequest;
import app.entities.Ride;
import app.entities.User;
import app.enums.RideStategy;
import app.enums.RideType;
import app.strategy.SelectionStrategy;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface RideDao {

    Ride offerRide(OfferRideRequest request);

    List<Ride> searchRides(SearchRideRequest request);

    Ride updateRide(String rideId,RideType rideType, Integer requestedSeats);

}
