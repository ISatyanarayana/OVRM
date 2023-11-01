package com.onlineVehicleRentalManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long DriverId;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String mobileNumber;
	
	private String emailId;
	
	private String licenseNo;
}
