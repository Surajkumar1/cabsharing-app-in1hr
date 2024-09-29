package app.strategy;


import app.entities.Ride;

import java.util.List;

public interface SelectionStrategy {

    Ride selectRide(List<Ride> rides);

}
