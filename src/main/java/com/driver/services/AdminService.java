package com.driver.services;

import java.util.List;

import com.driver.DTO.Response.CustomerResponse;
import com.driver.DTO.Response.DriverResponse;
import com.driver.model.Admin;
import com.driver.model.Customer;
import com.driver.model.Driver;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

	public void adminRegister(Admin admin);

	public Admin updatePassword(Integer adminId, String password);

	public void deleteAdmin(int adminId);

	public List<DriverResponse> getListOfDrivers();
	
	public List<CustomerResponse> getListOfCustomers();
}
