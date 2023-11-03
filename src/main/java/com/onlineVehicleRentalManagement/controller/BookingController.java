package com.onlineVehicleRentalManagement.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineVehicleRentalManagement.entity.Booking;
import com.onlineVehicleRentalManagement.entity.Customer;
import com.onlineVehicleRentalManagement.entity.Vehicle;
import com.onlineVehicleRentalManagement.service.IBookingService;

@RestController
@RequestMapping("/api/booking-controller")
public class BookingController {

	@Autowired
	private IBookingService bookingService;
	
	@PostMapping("/add-booking/{fromdate}/{todate}")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking,@PathVariable LocalDate fromDate,@PathVariable LocalDate toDate)
			throws Exception{
		if(booking==null || toDate==null ||fromDate==null || toDate.isBefore(fromDate))
			throw new Exception("Once check the given details");
		else 
			return new ResponseEntity<Booking>(bookingService.addBooking(booking, fromDate, toDate),HttpStatus.CREATED);
	}
	
	@PutMapping("/update-booking")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking b) throws Exception{
		if(b==null)
			throw new Exception("the object is empty");
		else
			return new ResponseEntity<Booking>(bookingService.updateBooking(b),HttpStatus.OK);
	}
	
	@DeleteMapping("/cance-booking")
	public ResponseEntity<Booking> cancelBooking(@RequestBody Booking b) throws Exception{
		if(b==null)
			throw new Exception("The object is Empty");
		else
			return new ResponseEntity<Booking>(bookingService.updateBooking(b),HttpStatus.OK);
	}
	
	@GetMapping("/viewBooking-byBooking/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable long bookingId) throws Exception{
		if(bookingId==0)
			throw new Exception("The object is Empty");
		else
			return new ResponseEntity<Booking>(bookingService.viewBooking(bookingId),HttpStatus.OK);
	}
	
	@GetMapping("/viewAllBookings-byVehicle")
	public ResponseEntity<List<Booking>> viewAllBookings(Vehicle v) throws  Exception{
		if(v==null)
			throw new Exception("The object is Empty");
		else
			return new ResponseEntity<List<Booking>>(bookingService.viewAllBookings(v),HttpStatus.OK);
	}
	
	@GetMapping("/viewAllBookings-byCustomer")
	public ResponseEntity<List<Booking>> viewAllBookings(Customer customer) throws Exception{
		if(customer==null)
			throw new Exception("The object is Empty");
		else
			return new ResponseEntity<List<Booking>>(bookingService.viewAllBookings(customer),HttpStatus.OK);	
	}
	
	@GetMapping("/viewAllBookings-bybookingDate/{bookingdate}")
	public ResponseEntity<List<Booking>> viewAllBookingByDate(@PathVariable LocalDate bdate) throws Exception{
		if(bdate==null)
			throw new Exception("The object is Empty");
		else
			return new ResponseEntity<List<Booking>>(bookingService.viewAllBookingByDate(bdate),HttpStatus.OK);	
	}
}
