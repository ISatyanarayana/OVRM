package com.onlineVehicleRentalManagement.service;

import com.onlineVehicleRentalManagement.entity.User;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
import com.onlineVehicleRentalManagement.exceptions.UserAlreadyExistsException;

public interface IUserService {

	public User validateUser(long userId,String password) throws Exception;
	public User addUser(User user) throws UserAlreadyExistsException;
	public User removeUser(User user) throws ResourceNotFoundException;
	//public User signOut(User user);
}
