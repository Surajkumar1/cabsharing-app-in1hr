package app.dao;

import app.dto.request.OfferRideRequest;
import app.dto.request.SearchRideRequest;
import app.entities.Ride;
import app.entities.User;
import app.enums.RideStategy;
import app.enums.RideType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Qualifier("RideDaoImpl")
public class RideDaoImpl implements RideDao{

    Map<String, Ride> rideMap = new HashMap<>();
    String offered = "OFFERED";

    public Ride offerRide(OfferRideRequest request){
        Ride ride = Ride.builder()
                .userId(request.getUserId())
                .vehicleId(request.getVehicleId())
                .source(request.getSource())
                .destination(request.getDestination())
                .availableSeat(request.getAvailableSeat())
                .bookedSeats(0)
                .status(offered)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime()).build();
        ride.setRideId(String.valueOf(rideMap.size()));
        rideMap.put(ride.getRideId(), ride);
        return ride;
    }

    public List<Ride> searchRides(SearchRideRequest request){
        List<Ride> rides = rideMap.values().stream()
                .filter(ride -> !ride.getUserId().equals(request.getUserId()))
                .filter(ride -> ride.getSource().equals(request.getSource()))
                .filter(ride -> ride.getDestination().equals(request.getDestination()))
                .filter(ride -> ride.getStartTime() >= request.getStartTime() && ride.getEndTime() <= ride.getEndTime())
                .filter(ride -> ride.getStatus().equals(offered) || ride.getBookedSeats() + request.getNumSeats() <= ride.getAvailableSeat())
                .filter(ride -> {
                    if(request.getRideType() == RideType.SOLO && ride.getBookedSeats() > 0) return false;
                    return true;
                })
                .collect(Collectors.toList());
        return rides;
    }

    public Ride updateRide(String rideId, RideType rideType, Integer requestSeats){
        Ride ride = rideMap.get(rideId);
        ride.setBookedSeats(ride.getBookedSeats() + requestSeats);
        if(rideType == RideType.SOLO){
            ride.setStatus("BOOKED");
        } else if(ride.getBookedSeats() == ride.getAvailableSeat()){
            ride.setStatus("BOOKED");
        } else {
            ride.setStatus("PARTIALLY BOOKED");
        }
        rideMap.put(rideId, ride);
        return ride;
    }

}
