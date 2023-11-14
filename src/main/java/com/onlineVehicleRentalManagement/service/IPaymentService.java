package com.onlineVehicleRentalManagement.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import com.onlineVehicleRentalManagement.entity.Booking;
import com.onlineVehicleRentalManagement.entity.Payment;
import com.onlineVehicleRentalManagement.entity.Vehicle;
 
import com.onlineVehicleRentalManagement.exceptions.PaymentAlreadyExistsException;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;

public interface IPaymentService {

	public Payment addPayment(Payment payment,Long bookingId) throws PaymentAlreadyExistsException, ResourceNotFoundException;
	public Payment cancelPayment(Payment payment) throws ResourceNotFoundException;
	public Payment viewPayment(Long paymentId) throws ResourceNotFoundException;
	public List<Payment> viewAllPayment(Long vehicleId) throws ResourceNotFoundException;
	public double calculateMonthlyRevenue(LocalDate d1,LocalDate d2) ;
	public double calculateTotalPayment(Vehicle vehicle) throws ResourceNotFoundException;
	 
	 
}
