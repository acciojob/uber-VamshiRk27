package com.driver.DTO.Response;

public class DriverResponse {
    private Integer driverId;
    private Integer cabId;

    public DriverResponse(Integer driverId, Integer cabId) {
        this.driverId = driverId;
        this.cabId = cabId;
    }

    public DriverResponse() {
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }
}
