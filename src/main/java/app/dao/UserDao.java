package app.dao;

import app.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User addUser(String name, String emailId, String mobileNo, String dob);

    User getUser(String userId);

}
