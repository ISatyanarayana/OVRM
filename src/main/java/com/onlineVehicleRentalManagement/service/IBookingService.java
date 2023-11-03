package com.onlineVehicleRentalManagement.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import com.onlineVehicleRentalManagement.entity.Booking;
import com.onlineVehicleRentalManagement.entity.Customer;
import com.onlineVehicleRentalManagement.entity.Vehicle;
import com.onlineVehicleRentalManagement.exceptions.BookingAlreadyExistsException;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;

public interface IBookingService {

	public Booking addBooking(Booking b,LocalDate fromDate,LocalDate toDate) throws BookingAlreadyExistsException;
	public Booking updateBooking(Booking b) throws ResourceNotFoundException;
	public Booking cancelBooking(Booking b) throws ResourceNotFoundException;
	public Booking viewBooking(long bookingId) throws ResourceNotFoundException;
	public List<Booking> viewAllBookings(Vehicle v) throws ResourceNotFoundException;
	public List<Booking> viewAllBookings(Customer customer) throws ResourceNotFoundException;
	public List<Booking> viewAllBookingByDate(LocalDate bdate) throws ParseException, ResourceNotFoundException;
}
