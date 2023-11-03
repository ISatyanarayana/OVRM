package com.onlineVehicleRentalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.onlineVehicleRentalManagement.entity.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Long> {

}
