package com.onlineVehicleRentalManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineVehicleRentalManagement.entity.Booking;
import com.onlineVehicleRentalManagement.entity.Vehicle;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Long> {

	
	@Query(value = "select totalCost from Booking a where a.vehicle=?1")
	List<?> findAllById(Vehicle vehicle);
	
	 
	
}
