package com.onlineVehicleRentalManagement.service;

import java.time.LocalDate;
import java.util.List;

import com.onlineVehicleRentalManagement.entity.Booking;
import com.onlineVehicleRentalManagement.entity.Customer;
import com.onlineVehicleRentalManagement.entity.Vehicle;

public interface IBookingService {

	public Booking addBooking(Booking b);
	public Booking updateBooking(Booking b);
	public Booking cancelBooking(Booking b);
	public Booking viewBooking(Booking b);
	public List<Booking> viewAllBookings(Vehicle v);
	public List<Booking> viewAllBookings(Customer customer);
	public List<Booking> viewAllBookingByDate(LocalDate bdate);
	
	
	
}
