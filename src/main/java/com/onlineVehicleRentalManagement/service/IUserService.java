package com.onlineVehicleRentalManagement.service;

import com.onlineVehicleRentalManagement.entity.User;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
import com.onlineVehicleRentalManagement.exceptions.UserAlreadyExistsException;

public interface IUserService {


	public User validateUser(Long userId, String password) throws ResourceNotFoundException, Exception;
	public User addUser(User user) throws UserAlreadyExistsException;
	public User removeUser(Long userId) throws ResourceNotFoundException;
	

}
