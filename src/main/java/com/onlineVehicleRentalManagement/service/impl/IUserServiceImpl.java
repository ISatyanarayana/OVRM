//package com.onlineVehicleRentalManagement.service.impl;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.onlineVehicleRentalManagement.entity.Customer;
//import com.onlineVehicleRentalManagement.entity.User;
//import com.onlineVehicleRentalManagement.exceptions.ResourceNotFoundException;
//import com.onlineVehicleRentalManagement.exceptions.UserAlreadyExistsException;
//import com.onlineVehicleRentalManagement.repository.ICustomerRepository;
//import com.onlineVehicleRentalManagement.repository.IUserRepository;
//import com.onlineVehicleRentalManagement.service.IUserService;
//
//public class IUserServiceImpl implements IUserService {
//
//	@Autowired
//	private IUserRepository iUserRepository;
//	
//	@Override
//	public User validateUser(long userId,String password) throws Exception{
//		
//		User user = iUserRepository.findById(userId).orElseThrow(
//				() -> new ResourceNotFoundException("Invalid Credentials"));
//		if(user.getUserId()==userId && user.getPassword().equals(password)) {
//			return user;
//		}
//		else
//			throw new Exception("Invalid credentials!!"); 
//	}
//
//	@Override
//	public User addUser(User user) throws UserAlreadyExistsException {
//		
//		Optional<User> findById = iUserRepository.findById(user.getUserId());
//		
//		if(!findById.isEmpty()) 
//			throw new UserAlreadyExistsException("User alredy exists with id: "+user.getUserId());
//		else
//			return iUserRepository.save(user);
//	}
//
//	@Override
//	public User removeUser(User user) throws ResourceNotFoundException {
//		
//		Optional<User> findById = iUserRepository.findById(user.getUserId());
//		if(findById.isEmpty()) 
//			throw new ResourceNotFoundException("User doesnt exists with id: "+user.getUserId());
//		else
//			iUserRepository.delete(user);
//		return findById.get();
//	}
////
////	@Override
////	public User signOut(User user) {
////		
////	}
//
//}
