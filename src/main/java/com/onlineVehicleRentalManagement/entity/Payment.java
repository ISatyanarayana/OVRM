package com.onlineVehicleRentalManagement.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Payment {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long paymentId;
		
		private String paymentMode;
		
		private LocalDate paymentDate;
		
		@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
		private Booking booking;
		
		private String paymentStatus;
}
