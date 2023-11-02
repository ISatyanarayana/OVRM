package com.onlineVehicleRentalManagement.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.onlineVehicleRentalManagement.entity.Booking;
import com.onlineVehicleRentalManagement.entity.Customer;
import com.onlineVehicleRentalManagement.entity.Vehicle;
import com.onlineVehicleRentalManagement.exceptions.BookingAlreadyExistsException;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
import com.onlineVehicleRentalManagement.repository.IBookingRepository;
import com.onlineVehicleRentalManagement.repository.ICustomerRepository;
import com.onlineVehicleRentalManagement.service.IBookingService;

@Service
public class BookingServiceImpl implements IBookingService{

	@Autowired
	private IBookingRepository bookingRepository;
	
	
	private ICustomerRepository customerRepository;
	
	@Override
	public Booking addBooking(Booking b,LocalDate fromDate,LocalDate toDate) throws BookingAlreadyExistsException {
		Booking bk=null;
		
		Optional<Booking> findById = bookingRepository.findById(b.getBookingId());
		if(findById==null) {
			b.setBookingdate(fromDate);
			b.setBookedTillDate(toDate);
			bk=bookingRepository.save(b);}
		else
			throw new BookingAlreadyExistsException("Booking is already present whith id:"+b.getBookingId());
		return  bk;
	}

	@Override
	public Booking updateBooking(Booking b) throws ResourceNotFoundException {
		
		Booking ub = bookingRepository.findById(b.getBookingId())
		.orElseThrow(() -> new ResourceNotFoundException("Booking not found with id :"+b.getBookingId()));
		
		ub.setBookedTillDate(b.getBookedTillDate());
		ub.setBookingdate(b.getBookingdate());
		ub.setBookingDescription(b.getBookingDescription());
		ub.setBookingId(b.getBookingId());
		ub.setCustomer(b.getCustomer());
		ub.setDistance(b.getDistance());
		ub.setTotalCost(b.getTotalCost());
		ub.setVehicle(b.getVehicle());
		return bookingRepository.save(ub);
	}

	@Override
	public Booking cancelBooking(Booking b) throws ResourceNotFoundException {
		Booking cb = bookingRepository.findById(b.getBookingId())
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found with id :"+b.getBookingId()));
		bookingRepository.delete(cb);
		return cb;
	}

	@Override
	public Booking viewBooking(Booking b) throws ResourceNotFoundException {
		bookingRepository.findById(b.getBookingId())
		.orElseThrow(() -> new ResourceNotFoundException("Booking not found with id :"+b.getBookingId()));
		return b;
	}

	@Override
	public List<Booking> viewAllBookings(Vehicle v) throws ResourceNotFoundException {
		List<Booking> collect = bookingRepository.findAll().stream()
				.filter(a -> a.getVehicle().equals(v)).collect(Collectors.toList());
		if (collect.isEmpty())
			throw new ResourceNotFoundException("Bookings not found for the vehicle number :"
		+v.getVehicleNumber());
		else
			return collect;
	}

	@Override
	public List<Booking> viewAllBookings(Customer customer) throws ResourceNotFoundException {
		
		 List<Booking> collect1 = bookingRepository.findAll().stream()
			.filter(a -> a.getCustomer().equals(customer)).collect(Collectors.toList());
		 if (collect1.isEmpty())
				throw new ResourceNotFoundException("Bookings not found for the Customer with id :"
			+customer.getCustomerId());
			else
				return collect1;
	}

	@Override
	public List<Booking> viewAllBookingByDate(LocalDate bdate) throws ResourceNotFoundException {
		
		List<Booking> bd = bookingRepository.findAll().stream()
		.filter(a -> a.getBookingdate().isEqual(bdate)).collect(Collectors.toList());
		if(bd.isEmpty()) {
			throw new ResourceNotFoundException("Bookings not found for the date:"
					+bdate);}
		else
			return bd;
	}

}
