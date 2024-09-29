package app.service;

import app.dao.UserDao;
import app.dao.VehicleDao;
import app.dto.request.OnboardVehicleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VehicleOnboardService {

    @Autowired
    @Qualifier("UserDaoImpl")
    UserDao userDao;

    @Autowired
    @Qualifier("VehicleDaoImpl")
    VehicleDao vehicleDao;

    public void onboardVehicle(OnboardVehicleRequest request){
        if(userDao.getUser(request.getUserId()) == null) {

        }
        vehicleDao.addVehicle(request.getName(), request.getVehicleRegNo(), request.getMfgDate(), request.getUserId());
    }

}
