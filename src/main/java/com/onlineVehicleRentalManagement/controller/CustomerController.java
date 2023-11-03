package com.onlineVehicleRentalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineVehicleRentalManagement.entity.Customer;
import com.onlineVehicleRentalManagement.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private ICustomerService custService;

	@PostMapping("/add-customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws Exception {
		if (customer != null) {
			return new ResponseEntity<Customer>(custService.addCustomer(customer), HttpStatus.CREATED);
		}
		throw new Exception("Customer Object is null or empty");
	}

	@DeleteMapping("/remove-customer/{customerId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable long customerId) throws Exception {
		if (customerId == 0) {
			throw new Exception("Customer Id is Invalid");
		}

		return new ResponseEntity<Customer>(custService.removeCustomer(customerId), HttpStatus.OK);
	}

	@PutMapping("/update-customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws Exception {
		if (customer != null) {
			return new ResponseEntity<Customer>(custService.updateCustomer(customer), HttpStatus.OK);
		}
		throw new Exception("Customer Object is null or empty");
	}

	@GetMapping("/view-customer-by-id/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable long customerId) throws Exception {
		if (customerId == 0) {
			throw new Exception("Customer Id is Invalid");                                       
		} else {

			return new ResponseEntity<Customer>(custService.viewCustomer(customerId), HttpStatus.OK);
		}
	}
}
