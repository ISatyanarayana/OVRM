package com.onlineVehicleRentalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineVehicleRentalManagement.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
