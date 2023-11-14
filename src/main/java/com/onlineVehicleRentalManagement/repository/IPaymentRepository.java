package com.onlineVehicleRentalManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineVehicleRentalManagement.entity.Payment;
@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Long> {
	 
 

	 
    
}
