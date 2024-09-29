package app.strategy;


import app.entities.Ride;

import java.util.List;


public class EarlySelectionStrategy implements SelectionStrategy {

    public Ride selectRide(List<Ride> rides){
        Ride selectedRide = null;
        for(Ride ride: rides){
            if(selectedRide == null){
                selectedRide = ride;
            } else {
                if(ride.getStartTime() < selectedRide.getStartTime()){
                    selectedRide = ride;
                }
            }
        }
        return selectedRide;
    }

}
