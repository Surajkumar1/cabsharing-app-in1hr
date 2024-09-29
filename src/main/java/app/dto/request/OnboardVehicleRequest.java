package app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnboardVehicleRequest {

    String name;
    String vehicleRegNo;
    String mfgDate;
    String userId;

}
