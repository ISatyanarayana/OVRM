package com.onlineVehicleRentalManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="customerId")
public class Customer extends User {
	
	public String firstName;
	
	public String lastName;
	
	public String emailId;
	
	public long mobileNumber;
	
	public String address;
}
