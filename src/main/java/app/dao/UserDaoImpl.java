package app.dao;

import app.entities.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Repository
@Qualifier("UserDaoImpl")
public class UserDaoImpl implements UserDao {

    Map<String, User> userMap = new HashMap<>();

    public User addUser(String name, String emailId, String mobileNo, String dob){
        User user = User.builder()
                .name(name)
                .emailId(emailId)
                .mobileNo(mobileNo)
                .dob(dob).build();
        // String userId =  UUID.randomUUID().toString();
        String userId =  name;
        for(User user1: userMap.values()){
            if(user1.getEmailId().equals(emailId) || user1.getMobileNo().equals(mobileNo)) {
                //
            }
        }
        while(!userMap.containsKey(userId)){
            user.setUserId(userId);
            userMap.put(userId, user);
        }
        return user;
    }

    public User getUser(String userId){
        return userMap.get(userId);
    }

}
