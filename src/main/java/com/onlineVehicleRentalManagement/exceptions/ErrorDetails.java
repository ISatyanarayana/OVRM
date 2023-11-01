package com.onlineVehicleRentalManagement.exceptions;


import java.util.Date;

public class ErrorDetails {

	private Date date;

	private String message;

	private String uri;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public ErrorDetails(Date date, String message, String uri) {
		this.date = date;
		this.message = message;
		this.uri = uri;
	}

	public ErrorDetails() {
	}

}

