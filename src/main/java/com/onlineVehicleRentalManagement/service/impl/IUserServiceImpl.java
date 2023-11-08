
package com.onlineVehicleRentalManagement.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineVehicleRentalManagement.entity.User;
import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
import com.onlineVehicleRentalManagement.exceptions.UserAlreadyExistsException;
import com.onlineVehicleRentalManagement.repository.IUserRepository;
import com.onlineVehicleRentalManagement.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public User addUser(User user) throws UserAlreadyExistsException {

		Optional<User> r = userRepository.findById(user.getUserId());
		User us = null;
		if (r.isPresent()) {
			throw new UserAlreadyExistsException("User already exists with user Id " + user.getUserId());
		} else {
			us = userRepository.save(user);
		}

		return us;
	}

	@Override
	public User removeUser(Long userId) throws ResourceNotFoundException {
		User ur = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Details are not found"));
		userRepository.delete(ur);
		return ur;
	}

	@Override
	public User validateUser(Long userId, String password) throws Exception {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials"));
		if (user.getUserId() == userId && user.getPassword().equals(password)) {
			return user;
		} else
			throw new Exception("Invalid credentials!!");
	}
}

