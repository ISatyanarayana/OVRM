package com.onlineVehicleRentalManagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long bookingId;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Vehicle vehicle;
	
	private LocalDate bookingdate;
	
	private LocalDate bookedTillDate;
	
	private String bookingDescription;
	
	private double totalCost;
	
	private double distance;
}
