package com.driver.DTO.Request;

import com.driver.model.Cab;
import com.driver.model.TripBooking;

public class DriverRequest {
    private String mobile;
    private String password;
    private Cab cab;

    public DriverRequest(String mobile, String password, Cab cab) {
        this.mobile = mobile;
        this.password = password;
        this.cab = cab;
    }

    public DriverRequest() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }
}
