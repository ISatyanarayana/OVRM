
package com.onlineVehicleRentalManagement.controller;

import java.util.List;

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
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
import com.onlineVehicleRentalManagement.service.ICustomerService;

@RestController

@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@PostMapping("/add-customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws Exception {
		if (customer != null) {
			return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
		}
		throw new Exception("Customer Object is null or empty");
	}

	@DeleteMapping("/remove-customer/{customerId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable long customerId) throws Exception {
		if (customerId == 0) {
			throw new Exception("Customer Id is Invalid");
		}

		return new ResponseEntity<Customer>(customerService.removeCustomer(customerId), HttpStatus.OK);
	}

	@PutMapping("/update-customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws Exception {
		if (customer != null) {
			return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
		}
		throw new Exception("Customer Object is null or empty");
	}

	@GetMapping("/view-customer-by-id/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable long customerId) throws Exception {
		if (customerId == 0) {
			throw new Exception("Customer Id is Invalid");
		} else {

			return new ResponseEntity<Customer>(customerService.viewCustomer(customerId), HttpStatus.OK);
		}
	}

	@GetMapping("/veiw-all-customers")
	public ResponseEntity<List<Customer>> viewCustomer() throws ResourceNotFoundException {
		return new ResponseEntity<List<Customer>>(customerService.viewAllCustomer(), HttpStatus.OK);
	}

	@GetMapping("/veiw-all-customers/{address}")
	public ResponseEntity<List<Customer>> viewCustomer(@PathVariable String address) throws ResourceNotFoundException {
		return new ResponseEntity<List<Customer>>(customerService.viewAllCustomersByLocation(address), HttpStatus.OK);
	}

}
