package app.dao;

import app.entities.User;
import app.entities.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDao {

    Vehicle addVehicle(String name, String vehicleRegNo, String mfgDate, String userId);

    Vehicle getVehicle(String vechicleId);

    List<Vehicle> getVehicleByUser(String userId);

}
