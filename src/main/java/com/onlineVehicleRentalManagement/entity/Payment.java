package com.onlineVehicleRentalManagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="PaymentId")
public class Payment {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long paymentId;
		
		private String paymentMode;
		
		private LocalDate paymentDate;
		
		@OneToOne
		private Booking booking;
		
		private String paymentStatus;
}
