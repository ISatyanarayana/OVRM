package com.onlineVehicleRentalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineVehicleRentalManagement.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
