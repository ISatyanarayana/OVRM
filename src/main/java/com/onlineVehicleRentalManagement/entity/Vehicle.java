package com.onlineVehicleRentalManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vehicleId;
	
	private String vehicleNumber;
	
	@OneToOne
	private Driver driver;
	
	private String type;
	
	private String category;
	
	private String description;
	
	private int capacity;
	
	private double chargesPerKM;
	
	private double fixedCharges;
}
