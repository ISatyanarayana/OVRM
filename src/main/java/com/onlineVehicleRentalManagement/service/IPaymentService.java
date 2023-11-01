package com.onlineVehicleRentalManagement.service;

import java.time.LocalDate;
import java.util.List;

import com.onlineVehicleRentalManagement.entity.Payment;
import com.onlineVehicleRentalManagement.entity.Vehicle;

public interface IPaymentService {

	public Payment addPayment(Payment payment);
	public Payment cancelPayment(Payment payment);
	public Payment viewPayment(Payment payment);
	public List<Payment> viewAllPayment(Payment payment);
	public double calculateMonthlyRevenue(LocalDate d1,LocalDate d2);
	public double calculateTotalPayment(Vehicle vehicle);
	
}
