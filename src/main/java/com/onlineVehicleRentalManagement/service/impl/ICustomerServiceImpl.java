
package com.onlineVehicleRentalManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineVehicleRentalManagement.entity.Customer;
import com.onlineVehicleRentalManagement.exceptions.CustomerAlreadyExistsException;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
import com.onlineVehicleRentalManagement.repository.ICustomerRepository;
import com.onlineVehicleRentalManagement.service.ICustomerService;

@Service
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
		Optional<Customer> c = customerRepository.getCustomerById(customer.getUserId());
		if (c.isPresent()) {
			throw new CustomerAlreadyExistsException("Customer already present with Id : " + customer.getUserId());

		}
		return customerRepository.save(customer);
	}

	@Override
	public Customer removeCustomer(Long customerId) throws ResourceNotFoundException {
		Customer c = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Available"));
		customerRepository.delete(c);
		return c;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws ResourceNotFoundException {
		Customer c = customerRepository.getCustomerById(customer.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Available"));
		c.setAddress(customer.getAddress());
		c.setUserId(customer.getUserId());
		c.setEmailId(customer.getEmailId());
		c.setMobileNumber(customer.getMobileNumber());
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());

		return customerRepository.save(c);
	}

	@Override
	public Customer viewCustomer(Long customerId) throws ResourceNotFoundException {

		return customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found in the database"));
	}

	@Override
	public List<Customer> viewAllCustomer() throws ResourceNotFoundException {
		List<Customer> list = customerRepository.findAll();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("customers are not avilable  in the DB");
		} else {
			return list;
		}

	}

	@Override
	public List<Customer> viewAllCustomersByLocation(String address) throws ResourceNotFoundException {
		List<Customer> l1 = customerRepository.findAllByLocation(address);
		if (l1.isEmpty()) {
			throw new ResourceNotFoundException("customers are not avilable  in the DB");
		} else {
			return l1;
		}
	}
}
