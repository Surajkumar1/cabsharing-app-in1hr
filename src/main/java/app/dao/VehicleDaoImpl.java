package app.dao;

import app.entities.Vehicle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Qualifier("VehicleDaoImpl")
public class VehicleDaoImpl implements VehicleDao {

    Map<String, Vehicle> vehicleMap = new HashMap<>();

    public Vehicle addVehicle(String name, String vehicleRegNo, String mfgDate, String userId){
        Vehicle vehicle = Vehicle.builder()
                .name(name)
                .vehicleRegNo(vehicleRegNo)
                .mfgDate(mfgDate)
                .userId(userId).build();
        for(Vehicle vehicle1: vehicleMap.values()){
            if(vehicle1.getVehicleRegNo().equals(vehicleRegNo)) {
                //
            }
        }
        // String vehicleId =  UUID.randomUUID().toString();
        String vehicleId =  name;
        while(!vehicleMap.containsKey(vehicleId)){
            vehicle.setVehicleId(vehicleId);
            vehicleMap.put(vehicleId, vehicle);
        }
        return vehicle;
    }

    public Vehicle getVehicle(String vehicleId){
        return vehicleMap.get(vehicleId);
    }

    public List<Vehicle> getVehicleByUser(String userId){
        return vehicleMap.values().stream()
                .filter(vehicle -> userId.equals(vehicle.getUserId())).collect(Collectors.toList());
    }

}
