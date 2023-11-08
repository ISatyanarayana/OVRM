package com.onlineVehicleRentalManagement.exceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String msg) {
		super(msg);
}

}
