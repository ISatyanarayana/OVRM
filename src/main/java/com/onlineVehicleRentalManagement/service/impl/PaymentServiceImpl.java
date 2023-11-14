package com.onlineVehicleRentalManagement.service.impl;

 

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineVehicleRentalManagement.entity.Booking;
import com.onlineVehicleRentalManagement.entity.Payment;
import com.onlineVehicleRentalManagement.entity.Vehicle;
import com.onlineVehicleRentalManagement.exceptions.PaymentAlreadyExistsException;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
import com.onlineVehicleRentalManagement.repository.IBookingRepository;
import com.onlineVehicleRentalManagement.repository.IPaymentRepository;
import com.onlineVehicleRentalManagement.service.IPaymentService;
@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;
	
	@Autowired
	private IBookingRepository bookingRepository;
	
	
	 
	
	
	@Override
	public Payment addPayment(Payment payment,Long bookingId) throws PaymentAlreadyExistsException, 
	ResourceNotFoundException   {
		 Optional<?> add=paymentRepository.findById(payment.getPaymentId());
		 Booking booking = bookingRepository.findById(bookingId).orElseThrow(()->
		 new ResourceNotFoundException("Booking not found with id: "+bookingId));
		 
		 Payment ad=null;
		 
		 if (add.isPresent()) {
			 throw new PaymentAlreadyExistsException("Payment already exists with id : "+payment);
			
		}else {
			ad=paymentRepository.save(payment);
		}
		return ad;
	}

	
	
	@Override
	public Payment cancelPayment(Payment payment) throws ResourceNotFoundException   {
	 Payment p= paymentRepository.findById(payment.getPaymentId()).orElseThrow(()->
	 new ResourceNotFoundException("payment not found in the database"));
        Booking booking = payment.getBooking();
        
 	 
		paymentRepository.delete(p);
		bookingRepository.delete(booking);
		 return p;
	}
	
	

	@Override
	public Payment viewPayment(Long paymentId) throws ResourceNotFoundException {
	   
		return    paymentRepository.findById(paymentId).orElseThrow(()->
		new ResourceNotFoundException("booking id is not availbel"));
 
	
	}

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> viewAllPayment(Long vehicleId) throws ResourceNotFoundException {
 		 
			 List<Payment> collect = paymentRepository.findAll().stream().filter(a->
			 a.getBooking().getVehicle().getVehicleId()==vehicleId)
			 .collect(Collectors.toList());
	         if(collect.isEmpty())
	         {
	        	 throw new ResourceNotFoundException("Payment not found for vehicle ");
	         }
	         else
	         {
	        	 return collect;
	         }
		 
	}

	@Override
	public double calculateMonthlyRevenue(LocalDate fromDate, LocalDate todate) {
		 
		List<LocalDate> collect = paymentRepository.findAll().stream().map( a -> a.getPaymentDate()).
		filter(b -> b.compareTo(fromDate)>=0 && b.compareTo(todate)<=0).collect(Collectors.toList());
		
		 double revenue=0.0;
		 
		for(LocalDate ld: collect) {
			
			List<Double> collect2 = paymentRepository.findAll().stream().filter(a -> a.getPaymentDate().isEqual(ld)).
					map( p ->p.getBooking().getTotalCost()).collect(Collectors.toList());
			
			for(double d:collect2) {
				revenue+=d;
			}
		}
		return revenue;
	}

	@Override
	public double calculateTotalPayment(Vehicle vehicle) {
		List<Double> collect = bookingRepository.findAll().stream().filter(a -> a.getVehicle().equals(vehicle)).
				map(b -> b.getTotalCost()).collect(Collectors.toList());
		double totalPayment=0.00;
		for(double b: collect) {
			totalPayment+=b;
		}
		return totalPayment;
		
	}


	 
}
