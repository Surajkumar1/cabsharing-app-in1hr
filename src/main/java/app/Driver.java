package app;

import app.dto.request.*;
import app.entities.Ride;
import app.enums.RideStategy;
import app.enums.RideType;
import app.service.RideSharingService;
import app.service.UserService;
import app.service.VehicleOnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Driver {

    @Autowired
    UserService userService;

    @Autowired
    VehicleOnboardService vehicleOnboardService;

    @Autowired
    RideSharingService rideSharingService;

    private void minDays(){
        int b = 3;
        int k = 2;
        int n = 5;
        int[] arr = new int[n];
        arr[0] = 1; arr[1] = 10; arr[2] = 3; arr[3] = 10; arr[3] = 2;
        int max = -1;
        for(int i=0; i<n; i++){
            max = Math.max(arr[i], max);
        }
        int l = 0;
        int r = max;
        int sol = -1;
        while(l < r){
            int mid = (l+r)/2;
            if(valid(arr, mid, b, k)){
                r = mid - 1;
                sol = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println("Solution - " + sol);
    }

    private boolean valid(int[] arr, int cur, int b, int k){
        int p = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= cur){
                if(p + 1 == k){
                    p = 0;
                    b--;
                } else {
                    p++;
                }
            } else {
                if(p == k) {
                    b--;
                }
                p = 0;
            }
        }
        return b <= 0;
    }

    private void maxWater(){

        int n = 12;
        int[] arr = new int[n];
        arr[0] = 0; arr[1] = 1; arr[2] = 0;
        arr[3] = 2; arr[4] = 1; arr[5] = 0;
        arr[6] = 1; arr[7] = 3; arr[8] = 2;
        arr[9] = 1; arr[10] = 2; arr[11] = 1;

        int max = 0;
        int prev = arr[0];

        int sol = 0;
        int curr = 0;


        for(int i=1; i<n; i++){
            if(arr[i] >= arr[max]) {
                max = i;
            }
            if(arr[i] < prev){
                curr += prev - arr[i];
            } else {
                sol += curr;
                prev = arr[i];
                curr = 0;
            }
        }

        curr = 0;
        prev = arr[n-1];

        for(int i=n-2; i>=max; i--){
            if(arr[i] >= max) {
                max = i;
            }
            if(arr[i] < prev){
                curr += prev - arr[i];
            } else {
                sol += curr;
                prev = arr[i];
                curr = 0;
            }
        }

        System.out.println("Solution - " + sol);

    }



    /*
    attendance
     */




























    public void run() {
        System.out.println("Solution: " + runAttendance(10));
    }

    private long runAttendance(int n){
        if(n == 0) return 0;
        long[][][] dp = new long[n][2][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        long sol = backtrack(dp, 0, 0 , 0);
        System.out.println("Solution: " + sol);
        return sol;
    }

    private long backtrack(long[][][] dp, int ind, int a, int l){
        if(ind == dp.length) return 1;
        if(dp[ind][a][l] != -1) return dp[ind][a][l];
        long sum = 0;
        if(a < 1){
            sum += backtrack(dp, ind + 1, a + 1, 0);
        }
        if(l < 2){
            sum += backtrack(dp, ind + 1, a, l+1);
        }
        sum += backtrack(dp, ind+1, a, 0);
        dp[ind][a][l] = sum % (1000000009L);
        return dp[ind][a][l];
    }




    public void run2(){

        runAttendance(6);

        minDays();

        maxWater();

        UserCreationRequest ur1 = new UserCreationRequest("Rohan", "9789829638", "surajvadde@gmail.com", "dob");
        UserCreationRequest ur2 = new UserCreationRequest("Shashank", "9789829639", "suralvadde@gmail.com", "dob");
        UserCreationRequest ur3 = new UserCreationRequest("Nandini", "9789829649", "surakvadde@gmail.com", "dob");
        UserCreationRequest ur4 = new UserCreationRequest("Shipira", "9789829679", "suravadde@gmail.com", "dob");
        UserCreationRequest ur5 = new UserCreationRequest("Gaurav", "978982679", "suravade@gmail.com", "dob");
        userService.onboardUser(ur1);
        userService.onboardUser(ur2);
        userService.onboardUser(ur3);
        userService.onboardUser(ur4);
        userService.onboardUser(ur5);

        OnboardVehicleRequest vr1 = new OnboardVehicleRequest("v1", "123", "123", "Rohan");
        OnboardVehicleRequest vr2 = new OnboardVehicleRequest("v2", "124", "123", "Shashank");
        OnboardVehicleRequest vr3 = new OnboardVehicleRequest("v3", "125", "123", "Shipira");
        OnboardVehicleRequest vr4 = new OnboardVehicleRequest("v4", "126", "123", "Shipira");
        vehicleOnboardService.onboardVehicle(vr1);
        vehicleOnboardService.onboardVehicle(vr2);
        vehicleOnboardService.onboardVehicle(vr3);
        vehicleOnboardService.onboardVehicle(vr4);


        OfferRideRequest offer1 = new OfferRideRequest("Rohan", "v1", "HYDERABAD", "BANGALORE", 1,
                60L, 120L);
        OfferRideRequest offer2 = new OfferRideRequest("Shipira", "v3", "BANGALORE", "MYSORE", 1,
                150L, 180L);
        OfferRideRequest offer3 = new OfferRideRequest("Shipira", "v4", "BANGALORE", "MYSORE", 1,
                190L, 200L);
        OfferRideRequest offer4 = new OfferRideRequest("Shashank", "v2", "HYDERABAD", "BANGALORE", 1,
                125L, 145L);

        rideSharingService.offerRide(offer1);
        rideSharingService.offerRide(offer2);
        rideSharingService.offerRide(offer3);
        rideSharingService.offerRide(offer4);


        SelectRideRequest sr1 = new SelectRideRequest("Nandini", "BANGALORE", "MYSORE",
                0L, 1000L, 1, RideType.SOLO, RideStategy.FASTEST);
        Ride ride = rideSharingService.selectRide(sr1);

        System.out.println("Selected ride - " +  ride.toString());


    }


}
