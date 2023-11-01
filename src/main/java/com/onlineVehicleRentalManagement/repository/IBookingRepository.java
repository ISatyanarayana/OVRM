package com.onlineVehicleRentalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineVehicleRentalManagement.entity.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Long> {

}
