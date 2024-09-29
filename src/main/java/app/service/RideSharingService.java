package app.service;

import app.dao.RideDao;
import app.dto.request.OfferRideRequest;
import app.dto.request.SearchRideRequest;
import app.dto.request.SelectRideRequest;
import app.entities.Ride;
import app.enums.RideStategy;
import app.strategy.SelectionStrategy;
import app.strategy.StrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideSharingService {

    @Autowired
    @Qualifier("RideDaoImpl")
    RideDao rideDao;

    @Autowired
    StrategyFactory strategyFactory;

    public void offerRide(OfferRideRequest request){
        // validate user, vehicle
        rideDao.offerRide(request);
    }

    public List<Ride> searchRides(SearchRideRequest request){
        return rideDao.searchRides(request);
    }

    public Ride selectRide(SelectRideRequest request){
        SearchRideRequest searchRideRequest = SearchRideRequest.builder()
                .source(request.getSource())
                .destination(request.getDestination())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .userId(request.getUserId()).build();
        List<Ride> rides = rideDao.searchRides(searchRideRequest);
        RideStategy rideStategy = request.getRideStategy();
        SelectionStrategy selectionStrategy = strategyFactory.getSelectionStrategy(rideStategy);
        Ride ride = selectionStrategy.selectRide(rides);
        if(ride == null){
            return null;
        }
        rideDao.updateRide(ride.getRideId(), request.getRideType(), request.getNumSeats());
        return ride;
    }

}
