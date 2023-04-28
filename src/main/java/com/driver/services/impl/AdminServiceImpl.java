package com.driver.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.driver.DTO.Response.CustomerResponse;
import com.driver.DTO.Response.DriverResponse;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Admin;
import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.AdminRepository;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository1;

	@Autowired
	DriverRepository driverRepository1;

	@Autowired
	CustomerRepository customerRepository1;

	@Override
	public void adminRegister(Admin admin) {
		//Save the admin in the database
		adminRepository1.save(admin);
	}

	@Override
	public Admin updatePassword(Integer adminId, String password) {
		//Update the password of admin with given id
		Admin admin=adminRepository1.findById(adminId).get();
		admin.setPassword(password);
		adminRepository1.save(admin);
		return admin;
	}

	@Override
	public void deleteAdmin(int adminId){
		// Delete admin without using deleteById function
		Admin admin=adminRepository1.findById(adminId).get();
		adminRepository1.delete(admin);
	}

	@Override
	public List<DriverResponse> getListOfDrivers() {
		//Find the list of all drivers
		List<Driver> drivers=driverRepository1.findAll();
		List<DriverResponse> responseList=new ArrayList<>();
		for(Driver driver:drivers){
			DriverResponse response=new DriverResponse();
			response.setDriverId(driver.getDriverId());
			response.setCabId(driver.getCab().getId());
			responseList.add(response);
		}
		return responseList;
	}

	@Override
	public List<CustomerResponse> getListOfCustomers() {
		//Find the list of all customers
		List<Customer> customers=customerRepository1.findAll();
		List<CustomerResponse> responseList=new ArrayList<>();
		for(Customer customer :customers){
			CustomerResponse response=new CustomerResponse();
			response.setCustomerId(customer.getCustomerId());
			response.setMobile(customer.getMobile());
			responseList.add(response);
		}
		return responseList;
	}
}
