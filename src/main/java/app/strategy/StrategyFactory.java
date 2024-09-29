package app.strategy;


import app.entities.Ride;
import app.enums.RideStategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StrategyFactory {

    Map<RideStategy, SelectionStrategy> selectionStrategyMap;

    public StrategyFactory(){
        selectionStrategyMap = new HashMap<>();
        selectionStrategyMap.put(RideStategy.EARLIEST, new EarlySelectionStrategy());
        selectionStrategyMap.put(RideStategy.FASTEST, new FastSelectionStrategy());
    }

    public SelectionStrategy getSelectionStrategy(RideStategy rideStategy){
        if(rideStategy == RideStategy.EARLIEST) return selectionStrategyMap.get(RideStategy.EARLIEST);
        if(rideStategy == RideStategy.FASTEST) return selectionStrategyMap.get(RideStategy.FASTEST);
        // default handling
        return selectionStrategyMap.get(RideStategy.EARLIEST);
    }

}
