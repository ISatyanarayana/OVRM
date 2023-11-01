package com.onlineVehicleRentalManagement.service;

import java.util.List;

import com.onlineVehicleRentalManagement.entity.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer viewCustomer(Customer customer);
	public List<Customer> viewAllCustomer(String vtype);
	public List<Customer> viewAllCustomersByLocation(Customer customer);
}
