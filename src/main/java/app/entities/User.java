package app.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    String userId;
    String name;
    String mobileNo;
    String emailId;
    String dob;

}
