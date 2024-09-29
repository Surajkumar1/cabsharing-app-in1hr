package app.strategy;


import app.entities.Ride;

import java.util.List;

public class FastSelectionStrategy implements SelectionStrategy {

    public Ride selectRide(List<Ride> rides){
        Ride selectedRide = null;
        for(Ride ride: rides){
            if(selectedRide == null){
                selectedRide = ride;
            } else {
                if(ride.getEndTime() - ride.getStartTime() <
                        selectedRide.getEndTime() - selectedRide.getStartTime()){
                    selectedRide = ride;
                }
            }
        }
        return selectedRide;
    }

}
