package com.driver.services.impl;

import com.driver.model.*;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		Customer customer=customerRepository2.findById(customerId).get();
		customerRepository2.delete(customer);
	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		TripBooking booking=new TripBooking();
		booking.setFromLocation(fromLocation);
		booking.setToLocation(toLocation);
		booking.setDistanceInKm(distanceInKm);
		Customer customer=customerRepository2.findById(customerId).get();
		booking.setCustomer(customer);

		Driver driver = null;
		List<Driver> drivers= driverRepository2.findAll();
		for(Driver profile: drivers){
			if(profile.getCab().getAvailable()){
				driver=profile;
				break;
			}
		}
		if(driver==null){
			booking.setStatus(TripStatus.CANCELED);
			throw new Exception("No cab available!");
		}
		Cab cab=driver.getCab();
		booking.setBill(distanceInKm*cab.getPerKmRate());
		booking.setDriver(driver);
		booking.setStatus(TripStatus.CONFIRMED);
		cab.setAvailable(false);
		tripBookingRepository2.save(booking);
		return booking;
	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking trip=tripBookingRepository2.findByTripId(tripId);
		if(trip!=null){
			trip.setStatus(TripStatus.CANCELED);
			// Getting driver, Cab & Customer details
			Driver driver=trip.getDriver();
			Cab cab=driver.getCab();
			Customer customer=trip.getCustomer();
			cab.setAvailable(true);
			tripBookingRepository2.save(trip);
			driverRepository2.save(driver);
			customerRepository2.save(customer);
		}
	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		// Getting the trip details by id
		TripBooking trip=tripBookingRepository2.findByTripId(tripId);
		if(trip!=null) {
			// Getting driver, Cab & Customer details
			Driver driver=trip.getDriver();
			Cab cab=driver.getCab();
			Customer customer=trip.getCustomer();
			// Setting trip bill & status
			trip.setBill(cab.getPerKmRate()*trip.getDistanceInKm());
			trip.setStatus(TripStatus.COMPLETED);
			// Changing cab availability
			cab.setAvailable(true);
			// Getting trip list of customer and driver
			List<TripBooking> driverTripList=driver.getTripBookingList();
			List<TripBooking> customerTripList=customer.getTripBookingList();
			// Adding current trip to the resp lists
			driverTripList.add(trip);
			customerTripList.add(trip);
			tripBookingRepository2.save(trip);
			driverRepository2.save(driver);
			customerRepository2.save(customer);
		}
	}
}
