
package com.onlineVehicleRentalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineVehicleRentalManagement.entity.User;
import com.onlineVehicleRentalManagement.exceptions.InvalidCredentials;
import com.onlineVehicleRentalManagement.service.IUserService;


@RestController

@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/add-user")
	public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
		if (user != null) {
			return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
		}
		throw new Exception("User Object is null or empty");
	}
	@DeleteMapping("/remove-user/{userId}")
	public ResponseEntity<User> removeUser(@PathVariable Long userId) throws Exception {
		if (userId == 0) {
			throw new Exception("User Id is Invalid");
		}

		return new ResponseEntity<User>(userService.removeUser(userId), HttpStatus.OK);
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/validate-user/{userId}/{password}")
	public ResponseEntity<User> validateUser(@PathVariable Long userId, @PathVariable String password)
			throws Exception {
		if (userId == null && password == null && password == "") {
			throw new InvalidCredentials("UserId and password is incorrect");
		} else {
			return new ResponseEntity<User>(userService.validateUser(userId, password),
					HttpStatus.ACCEPTED);
		}
	}
}
