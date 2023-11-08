package com.onlineVehicleRentalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineVehicleRentalManagement.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
