package app.service;

import app.dao.UserDao;
import app.dto.request.UserCreationRequest;
import app.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    @Qualifier("UserDaoImpl")
    UserDao userDao;

    public void onboardUser(UserCreationRequest request){
        userDao.addUser(request.getName(), request.getEmailId(), request.getMobileNumber(), request.getDob());
    }

    public User getUser(String userId){
        User user = userDao.getUser(userId);
        if(user == null){

        }
        return user;
    }

}
