package com.onlineVehicleRentalManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineVehicleRentalManagement.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "select c from Customer c where c.userId=?1")
	public Optional<Customer> getCustomerById(Long customerId);
	@Query(value = "select c from Customer c where c.address=?1")
	public List<Customer> findAllByLocation(String address);
}
