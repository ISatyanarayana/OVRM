package com.onlineVehicleRentalManagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineVehicleRentalManagement.entity.Payment;
import com.onlineVehicleRentalManagement.entity.Vehicle;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
import com.onlineVehicleRentalManagement.service.IPaymentService;

@RestController
@RequestMapping("/api/payment")
public class paymentController<Payments> {
	
    @Autowired
	private IPaymentService paymentservice;
	
	
	@PostMapping("/add-payment/{bookingId}")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment ,@PathVariable Long bookingId) throws Exception
	{
		if(payment==null || bookingId==0)
		{
			throw new Exception("Object is null");
		}
		else
		{
			return new ResponseEntity<Payment>(paymentservice.addPayment(payment, bookingId),HttpStatus.CREATED);
		}
	}
	
	
 @DeleteMapping("/cancel-payment")
 public ResponseEntity<Payment>cancelPayment(@RequestBody Payment payment) throws Exception
 {
	 if(payment==null)
	 {
		 throw new Exception ("payment shouldn't be null");
	 }
	 else
	 {
		 return new ResponseEntity<Payment>(paymentservice.cancelPayment(payment),HttpStatus.OK);
	 }
 }
	@GetMapping("/viewPayment/{paymentid}")
	public ResponseEntity<Payment>viewPayment(Long paymentId) throws ResourceNotFoundException
	{
		return new ResponseEntity <Payment>(paymentservice.viewPayment(paymentId),HttpStatus.OK);
	}

	
	@GetMapping("viewAllPayments/{vehicleId}")
	
	public ResponseEntity<List<Payment>>viewAllPayment(Long vehicleId) throws ResourceNotFoundException 
	{
		return new ResponseEntity<List<Payment>>( paymentservice.viewAllPayment(vehicleId),HttpStatus.OK);
	}
	
	
	
	@GetMapping("calculateMonthlyRevenue/{fromdate}/{todate}")
	public ResponseEntity<?>calculateMonthlyRevenue(@PathVariable LocalDate d1,@PathVariable LocalDate d2) throws Exception
	{
		if(d1==null&& d2==null)
		{
			throw new Exception("some think went wrong ");
		}
		else 
		{
			return new ResponseEntity<>(paymentservice.calculateMonthlyRevenue(d1, d2),HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/getvehicalcost/{vehicalId}")
	public ResponseEntity<?> calculateTotalPayment(@PathVariable Vehicle vehicle) throws ResourceNotFoundException
	{
		return   ResponseEntity.ok(paymentservice.calculateTotalPayment(vehicle));
	
	}
	




}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
