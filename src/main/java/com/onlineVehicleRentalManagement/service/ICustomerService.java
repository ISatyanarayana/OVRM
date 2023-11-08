package com.onlineVehicleRentalManagement.service;

import java.util.List;

import com.onlineVehicleRentalManagement.entity.Customer;
import com.onlineVehicleRentalManagement.exceptions.CustomerAlreadyExistsException;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
public interface ICustomerService {

	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException ;
	public Customer removeCustomer(Long customerId) throws ResourceNotFoundException;
	public Customer updateCustomer(Customer customer) throws ResourceNotFoundException;
	public Customer viewCustomer(Long customerId) throws ResourceNotFoundException;
	public List<Customer> viewAllCustomer() throws ResourceNotFoundException;
	public List<Customer> viewAllCustomersByLocation(String address) throws ResourceNotFoundException;
}
