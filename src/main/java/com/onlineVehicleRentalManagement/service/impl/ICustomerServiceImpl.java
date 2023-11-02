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
	private ICustomerRepository custRepository;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
		Optional<Customer> c = custRepository.getCustomerById(customer.getCustomerId());
		if (c.isPresent()) {
			throw new CustomerAlreadyExistsException("Customer already present with Id : " + customer.getCustomerId());

		}
		return custRepository.save(customer);
	}

	@Override
	public Customer removeCustomer(Long customerId) throws ResourceNotFoundException {
		Customer c = custRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Available"));
		custRepository.delete(c);
		return c;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws ResourceNotFoundException {
		Customer c = custRepository.getCustomerById(customer.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Available"));
		c.setAddress(customer.getAddress());
		c.setCustomerId(customer.getCustomerId());
		c.setEmailId(customer.getEmailId());
		c.setMobileNumber(customer.getMobileNumber());
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());

		return custRepository.save(c);
	}

	@Override
	public Customer viewCustomer(Long customerId) throws ResourceNotFoundException {

		return custRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found in the database"));
	}

	

	@Override
	public List<Customer> viewAllCustomer(String vtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomersByLocation(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
