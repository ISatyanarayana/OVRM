package com.onlineVehicleRentalManagement.service;

import com.onlineVehicleRentalManagement.entity.User;

public interface IUserService {

	public User validateUser(User user);
	public User addUser(User user);
	public User removeUser(User user);
	public User signOut(User user);
}
