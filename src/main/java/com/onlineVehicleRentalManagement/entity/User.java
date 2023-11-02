package com.onlineVehicleRentalManagement.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name="user_id")
public class User extends Customer{
	private String userId;
	private String password;
	private String role;
}
