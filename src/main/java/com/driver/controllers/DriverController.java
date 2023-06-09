package com.driver.controllers;

import com.driver.services.DriverService;
import com.driver.services.impl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/driver")
public class DriverController {
	@Autowired
	DriverServiceImpl driverService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Void> registerDriver(@RequestParam("mobile") String mobile, @RequestParam("password") String password){
		driverService.register(mobile, password);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteDriver(@RequestParam("id") Integer driverId){
		driverService.removeDriver(driverId);
	}

	@PutMapping("/status")
	public void updateStatus(@RequestParam("id") Integer driverId){
		driverService.updateStatus(driverId);
	}
}
