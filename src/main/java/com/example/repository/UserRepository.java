package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.UserModel;

@Repository

public interface UserRepository extends JpaRepository<UserModel, Integer> {

	@Query("Select U from UserModel U where email=:email and password=:password")
	UserModel findByEmailPassword(@Param("email")String email, @Param("password")String password);


}
