package com.driver.model;

import javax.persistence.*;

@Entity
@Table(name="tripbooking")
public class TripBooking{
    public TripBooking() {
    }

    public TripBooking(int tripId, String fromLocation, String toLocation, int distanceInKm, TripStatus status, int bill, Driver driver, Customer customer) {
        this.tripId = tripId;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.distanceInKm = distanceInKm;
        this.status = status;
        this.bill = bill;
        this.driver = driver;
        this.customer = customer;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int tripId;
    private String fromLocation;
    private String toLocation;
    private int distanceInKm;
    @Enumerated(EnumType.STRING)
    private TripStatus status;
    private int bill;
    @ManyToOne
    @JoinColumn
    Driver driver;
    @ManyToOne
    @JoinColumn
    Customer customer;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(int distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}